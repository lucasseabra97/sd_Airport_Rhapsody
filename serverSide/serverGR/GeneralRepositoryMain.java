package serverSide.serverGR;

import java.io.File;
import java.io.IOException;
import java.net.SocketTimeoutException;

import main.global;
import serverSide.ServerCom;

public class GeneralRepositoryMain {   


   /**
   *  Número do port de escuta do serviço a ser prestado (4000, por defeito)
   *
   *    @serialField portNumb
   */

   private static final int portNumb = global.SERVER_PORT_NUMB_GR;
   public static boolean waitConnection;                              // sinalização de actividade

  /**
   * Programa principal.
   * 
   * @throws IOException
   */

    public static void main(String [] args)throws IOException{
        File logger = new File("logger.txt");
		if (logger.createNewFile()){
        }
        else{
			logger.delete();
			logger.createNewFile(); 
        }
        
        GeneralRepository monitorGR;                                  // barbearia (representa o serviço a ser prestado)
        GeneralRepositoryInterface atExitInter;                       // interface à barbearia
        ServerCom scon, sconi;                                          // canais de comunicação
        Proxy cliProxy;                                                // thread agente prestador do serviço
        
        scon = new ServerCom (portNumb);                     // criação do canal de escuta e sua associação
        scon.start ();                                       // com o endereço público
        monitorGR = new GeneralRepository(logger);                           // activação do serviço
        atExitInter = new GeneralRepositoryInterface (monitorGR);        // activação do interface com o serviço
        System.out.println("O serviço foi estabelecido! TemporaryStorageArea");
        System.out.println("O servidor esta em escuta na porta: "+ portNumb);


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
        monitorGR.close();
        scon.end ();                                         // terminação de operações
        System.out.println("O servidor foi desactivado.");

    }
}