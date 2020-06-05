
package serverSide.serverATE;

import java.io.*;
import java.net.SocketTimeoutException;

import clientSide.stubs.GeneralRepositoryStub;
import main.global;

import serverSide.ServerCom;


public class ArraivalTerminalExitMain {
    /**
   *  Número do port de escuta do serviço a ser prestado (4000, por defeito)
   *
   *    @serialField portNumb
   */

   private static final int portNumb = 3003;
   public static boolean waitConnection;                              // sinalização de actividade

  /**
   * Programa principal.
   * 
   * @throws IOException
   */

  public static void main(String[] args) throws IOException
   {  
    
        File logger = new File("logger.txt");
        if(logger.createNewFile()){
            //System.out.println("Logger created: " + logger.getName());
        }
        else{
            logger.delete();
            logger.createNewFile();
            // System.out.println("File already exists.");
        }

        //GeneralRepository genInfoRepo = new GeneralRepository(logger);

        ArraivalTerminalExit monitorATE;                                  // barbearia (representa o serviço a ser prestado)
        ArraivalTerminalExitInterface atExitInter;                       // interface à barbearia
        ServerCom scon, sconi;                                          // canais de comunicação
        Proxy cliProxy;                                                // thread agente prestador do serviço

        /* estabelecimento do servico */

        scon = new ServerCom (portNumb);                                     // criação do canal de escuta e sua associação
        scon.start ();     
        
        GeneralRepositoryStub grStub = new GeneralRepositoryStub("localhost",3002);   // com o endereço público
        monitorATE = new ArraivalTerminalExit(grStub);                           // activação do serviço
        atExitInter = new ArraivalTerminalExitInterface (monitorATE);        // activação do interface com o serviço
        System.out.println("O serviço foi estabelecido! ArraivalTerminalExit");
        System.out.println("O servidor esta em escuta na porta: "+ portNumb);

        /* processamento de pedidos */
        //NAO SEI ONDE METER ISTO MAS É NECESSARIO
        //genInfoRepo.close();
        waitConnection = true;
        while (waitConnection)
            try
            { sconi = scon.accept ();                          // entrada em processo de escuta
            cliProxy = new Proxy (sconi, atExitInter);  // lançamento do agente prestador do serviço
            cliProxy.start ();
            }
            catch (SocketTimeoutException e)
            {
            }
        scon.end ();                                         // terminação de operações
        System.out.println("O servidor foi desactivado.");
    }    
}