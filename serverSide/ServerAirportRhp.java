package serverSide;

import java.net.SocketTimeoutException;

/**
 *   
 *   modelo cliente-servidor de tipo 2 (replicação do servidor) com lançamento estático dos threads barbeiro.
 *   A comunicação baseia-se em passagem de mensagens sobre sockets usando o protocolo TCP.
 */

public class ServerAirportRhp
{
  /**
   *  Número do port de escuta do serviço a ser prestado (4000, por defeito)
   *
   *    @serialField portNumb
   */

   private static final int portNumb = 22001;
   public static boolean waitConnection;                              // sinalização de actividade

  /**
   *  Programa principal.
   */

   public static void main (String [] args)
   {
      BarberShop bShop;                                    // barbearia (representa o serviço a ser prestado)
      BarberShopInterface bShopInter;                      // interface à barbearia
      ServerCom scon, sconi;                               // canais de comunicação
      ClientProxy cliProxy;                                // thread agente prestador do serviço

     /* estabelecimento do servico */

      scon = new ServerCom (portNumb);                     // criação do canal de escuta e sua associação
      scon.start ();                                       // com o endereço público
      bShop = new BarberShop ();                           // activação do serviço
      bShopInter = new BarberShopInterface (bShop);        // activação do interface com o serviço
      System.out.println("O serviço foi estabelecido!");
      System.out.println("O servidor esta em escuta.");

     /* processamento de pedidos */

      waitConnection = true;
      while (waitConnection)
        try
        { sconi = scon.accept ();                          // entrada em processo de escuta
          cliProxy = new ClientProxy (sconi, bShopInter);  // lançamento do agente prestador do serviço
          cliProxy.start ();
        }
        catch (SocketTimeoutException e)
        {
        }
      scon.end ();                                         // terminação de operações
      System.out.println("O servidor foi desactivado.");
   }
}
