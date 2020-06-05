
package serverSide.serverDTE;

import java.io.*;
import java.net.SocketTimeoutException;

import clientSide.stubs.GeneralRepositoryStub;
import main.global;

import serverSide.ServerCom;
//import shared_regions.GeneralRepository;

public class DepartureTerminalEntranceMain {
    /**
   *  Número do port de escuta do serviço a ser prestado (4000, por defeito)
   *
   *    @serialField portNumb
   */

   private static final int portNumb = 3008;
   public static boolean waitConnection;                              // sinalização de actividade

  /**
   * Programa principal.
   * 
   * @throws IOException
   */

  public static void main(String[] args) throws IOException
   {  
    
       
        //GeneralRepository genInfoRepo = new GeneralRepository(logger);

        DepartureTerminalEntrance monitorDTE;                                  // barbearia (representa o serviço a ser prestado)
        DepartureTerminalEntranceInterface atExitInter;                       // interface à barbearia
        ServerCom scon, sconi;                                          // canais de comunicação
        Proxy cliProxy;                                                // thread agente prestador do serviço

        /* estabelecimento do servico */

        scon = new ServerCom (portNumb);                                               // criação do canal de escuta e sua associação
        scon.start ();                                                                // com o endereço público
        GeneralRepositoryStub grStub = new GeneralRepositoryStub("localhost",3002);
        monitorDTE = new DepartureTerminalEntrance(grStub);                           // activação do serviço
        atExitInter = new DepartureTerminalEntranceInterface (monitorDTE);        // activação do interface com o serviço
        System.out.println("O serviço foi estabelecido! DepartureTerminalEntrance");
        System.out.println("O servidor esta em escuta na porta: "+ portNumb);

        /* processamento de pedidos */
       
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