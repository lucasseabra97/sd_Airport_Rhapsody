package clientSide.stubs;

import java.util.ArrayList;

import clientSide.ClientCom;
import commonInfra.BCPMessage;
import commonInfra.Baggage;
import interfaces.IBaggageCollectionPointPassenger;
import interfaces.IBaggageCollectionPointPorter;

public class BagageCollectionPointStub implements IBaggageCollectionPointPorter, IBaggageCollectionPointPassenger {

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

    public BagageCollectionPointStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    @Override
    public Baggage goCollectABag(ArrayList<Baggage> ibagp) {

        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        BCPMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new BCPMessage (BCPMessage.GO_COLLECT_A_BAG,ibagp);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (BCPMessage) con.readObject ();

        if ((inMessage.getMsgType() !=BCPMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        return inMessage.getBaggage();
    }

    @Override
    public void resetState() {
        // TODO Auto-generated method stub
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        BCPMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new BCPMessage (BCPMessage.RESET_STATE);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (BCPMessage) con.readObject ();

        if ((inMessage.getMsgType() !=BCPMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }

    @Override
    public void carryItToAppropriateStore(Baggage bag) {
        // TODO Auto-generated method stub
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        BCPMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new BCPMessage (BCPMessage.CARRY_IT_TO_APPROPRIATE_STORE,bag);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (BCPMessage) con.readObject ();

        if ((inMessage.getMsgType() !=BCPMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }

    @Override
    public void noMoreBagsToCollect() {
        
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        BCPMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new BCPMessage (BCPMessage.NO_MORE_BAGS_TO_COLLECT);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (BCPMessage) con.readObject ();

        if ((inMessage.getMsgType() !=BCPMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void shutdown(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        BCPMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new BCPMessage (BCPMessage.SHUTDOWN);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (BCPMessage) con.readObject ();

        if ((inMessage.getMsgType() !=BCPMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }
    
}