
package serverSide.serverTSA;

import java.io.*;
import java.net.SocketTimeoutException;

import clientSide.stubs.GeneralRepositoryStub;
import main.global;

import serverSide.ServerCom;
//import shared_regions.GeneralRepository;

public class TemporaryStorageAreaMain {
    /**
   *  Número do port de escuta do serviço a ser prestado (4000, por defeito)
   *
   *    @serialField portNumb
   */

   private static final int portNumb = global.SERVER_PORT_NUMB_TSA;
   public static boolean waitConnection;                              // sinalização de actividade

  /**
   * Programa principal.
   * 
   * @throws IOException
   */

  public static void main(String[] args) throws IOException
   {  

        /*
        File logger = new File("logger.txt");
        if(logger.createNewFile()){
            //System.out.prserverDTTQserverDTTQintln("Logger created: " + logger.getName());
        }
        else{
            logger.delete();
            logger.createNewFile();
            // System.out.println("File already exists.");
        }
        */
        //GeneralRepository genInfoRepo = new GeneralRepository(logger);

        TemporaryStorageArea monitorTSA;                                  // barbearia (representa o serviço a ser prestado)
        TemporaryStorageAreaInterface atExitInter;                       // interface à barbearia
        ServerCom scon, sconi;                                          // canais de comunicação
        Proxy cliProxy;                                                // thread agente prestador do serviço

        /* estabelecimento do servico */

        scon = new ServerCom (portNumb);                     // criação do canal de escuta e sua associação
        scon.start ();                                       // com o endereço público
        
        GeneralRepositoryStub grStub = new GeneralRepositoryStub(global.SERVER_HOST_NAME_GR,global.SERVER_PORT_NUMB_GR);
        monitorTSA = new TemporaryStorageArea(grStub);                           // activação do serviço
        atExitInter = new TemporaryStorageAreaInterface (monitorTSA);        // activação do interface com o serviço
        System.out.println("O serviço foi estabelecido! TemporaryStorageArea");
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