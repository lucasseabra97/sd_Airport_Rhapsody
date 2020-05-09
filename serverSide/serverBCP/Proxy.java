package serverSide.serverBCP;

import commonInfra.BCPMessage;
import commonInfra.BCPMessageException;
import serverSide.ServerCom;

public class Proxy extends Thread
{
  /**
   *  Contador de threads lançados
   *
   *    @serialField nProxy
   */

   private static int nProxy = 0;

  /**
   *  Canal de comunicação
   *
   *    @serialField sconi
   */

   private ServerCom sconi;

  /**
   *  Interface à barbearia
   *
   *    @serialField bShopInter
   */

   private BaggageCollectionPointInterface bcPointInter;

  /**
   *  Instanciação do interface à barbearia.
   *
   *    @param sconi canal de comunicação
   *    @param bShopInter interface à barbearia
   */

   public Proxy (ServerCom sconi, BaggageCollectionPointInterface bcPointInter)
   {
      super ("Proxy_" + Proxy.getProxyId ());

      this.sconi = sconi;
      this.bcPointInter = bcPointInter;
   }

  /**
   *  Ciclo de vida do thread agente prestador de serviço.
   */

   @Override
   public void run ()
   {
      BCPMessage inMessage = null,                                      // mensagem de entrada
              outMessage = null;                                        // mensagem de saída

      inMessage = (BCPMessage) sconi.readObject ();                     // ler pedido do cliente
      try
      { outMessage = bcPointInter.processAndReply (inMessage);         // processá-lo
      }
      catch (BCPMessageException e)
      { System.out.println("Thread " + getName () + ": " + e.getMessage () + "!");
        System.out.println(e.getMessageVal ().toString ());
        System.exit (1);
      }
      sconi.writeObject (outMessage);                                // enviar resposta ao cliente
      sconi.close ();                                                // fechar canal de comunicação
   }

  /**
   *  Geração do identificador da instanciação.
   *
   *    @return identificador da instanciação
   */

   private static int getProxyId ()
   {
      Class<?> cl = null;                                  // representação do tipo de dados ClientProxy na máquina
                                                           //   virtual de Java
      int proxyId;                                         // identificador da instanciação

      try
      { cl = Class.forName ("serverSide.serverBCP.Proxy");
      }
      catch (ClassNotFoundException e)
      { System.out.println("O tipo de dados Proxy não foi encontrado!");
        e.printStackTrace ();
        System.exit (1);
      }

      synchronized (cl)
      { proxyId = nProxy;
        nProxy += 1;
      }

      return proxyId;
   }

  /**
   *  Obtenção do canal de comunicação.
   *
   *    @return canal de comunicação
   */

   public ServerCom getScon ()
   {
      return sconi;
   }
}
