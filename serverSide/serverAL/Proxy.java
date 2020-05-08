package serverSide.serverAL;

import serverSide.ServerCom;
import commonInfra.ArraivalLoungeMessage;
import commonInfra.ALMessageException;

public class Proxy extends Thread {
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
    *  Interface ao Arraival Lounge
    *
    *    @serialField aloungeInter
    */
 
    private ArraivalLoungeInterface aloungeInter;

    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param sconi
     * @param aloungeInter
     */
    public Proxy (ServerCom sconi, ArraivalLoungeInterface aloungeInter){
        super ("Proxy_" + Proxy.getProxyId ());
        this.sconi = sconi;
        this.aloungeInter = aloungeInter;
    }

    /**
     *  Ciclo de vida do thread agente prestador de serviço.
     */
    @Override
    public void run (){
        ArraivalLoungeMessage inMessage = null,                                      // mensagem de entrada
              outMessage = null;                        // mensagem de saída

      inMessage = (ArraivalLoungeMessage) sconi.readObject ();                     // ler pedido do cliente
      try
      { outMessage = aloungeInter.processAndReply (inMessage);         // processá-lo
      }
      catch (ALMessageException e)
      { System.out.println ("Thread " + getName () + ": " + e.getMessage () + "!");
        System.out.println (e.getMessageVal ().toString ());
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
      { cl = Class.forName ("serverSide.ClientProxy");
      }
      catch (ClassNotFoundException e)
      { System.out.println ("O tipo de dados ClientProxy não foi encontrado!");
        e.printStackTrace ();
        System.exit (1);
      }

      synchronized (cl)
      { proxyId = nProxy;
        nProxy += 1;
      }

      return proxyId;
   }

}