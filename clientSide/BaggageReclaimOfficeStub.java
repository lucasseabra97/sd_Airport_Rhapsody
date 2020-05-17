package clientSide;

import java.util.ArrayList;

import commonInfra.BROMessage;
import commonInfra.Baggage;
import interfaces.IBaggageReclaimOfficePassenger;

public class BaggageReclaimOfficeStub implements IBaggageReclaimOfficePassenger {


     /**
   *  Nome do sistema computacional onde está localizado o servidor
   *    @serialField serverHostName
   */

   private String serverHostName = null;

   /**
    *  Número do port de escuta do servidor
    *    @serialField serverPortNumb
    */
 
    private int serverPortNumb;
 
    /**
     * 
     * @param serverHostName
     * @param serverPortNumb
     */
    
    public BaggageReclaimOfficeStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    @Override
    public void complain(ArrayList<Baggage> bags) {
    
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        BROMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new BROMessage (BROMessage.REQ_COMPLAIN,bags);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (BROMessage) con.readObject ();
       
        if (inMessage.getMsgType() != BROMessage.COMPLAIN_DONE)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }
    
}