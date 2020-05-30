package clientSide.stubs;

import java.util.ArrayList;

import clientSide.ClientCom;
import commonInfra.TSAMessage;
import commonInfra.Baggage;
import interfaces.ITemporaryStorageAreaPorter;

public class TemporaryStorageAreaStub implements ITemporaryStorageAreaPorter    {


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
    
    public TemporaryStorageAreaStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    @Override
    public void carryItToAppropriateStore(Baggage bag) {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        TSAMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new TSAMessage(TSAMessage.CARRY_IT_TO_APPROPRIATE_STORE , bag);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (TSAMessage) con.readObject ();
       
        if (inMessage.getMsgType() != TSAMessage.ACK)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }




}