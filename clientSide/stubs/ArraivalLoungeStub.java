package clientSide.stubs;

import commonInfra.Baggage;
import interfaces.*;

import java.util.List;

import clientSide.ClientCom;
import commonInfra.ArraivalLoungeMessage;
public class ArraivalLoungeStub implements IArraivalLoungePassenger, IArraivalLoungePorter {

    
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
    
    public ArraivalLoungeStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }
    
    @Override
    public boolean takeARest() {
        
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ArraivalLoungeMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ArraivalLoungeMessage (ArraivalLoungeMessage.TAKE_A_REST);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ArraivalLoungeMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ArraivalLoungeMessage.ACK) && inMessage.getMsgType() != ArraivalLoungeMessage.END_OF_DAY)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
        
        //if (inMessage.getMsgType() == ArraivalLoungeMessage.TAKE_A_REST_DONE)
        return inMessage.getMsgType() != ArraivalLoungeMessage.END_OF_DAY;                                                // operação bem sucedida - corte efectuado

    }

    

    @Override
    public Baggage tryToCollectABag() {
        
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ArraivalLoungeMessage inMessage, outMessage;

        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new ArraivalLoungeMessage (ArraivalLoungeMessage.TRY_TO_COLLECCT_A_BAG);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (ArraivalLoungeMessage) con.readObject ();
       
        if (inMessage.getMsgType() != ArraivalLoungeMessage.ACK)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        return inMessage.tryToCollectABag();
    }

    @Override
    public void whatShouldIDO(Boolean goHome) {
    
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ArraivalLoungeMessage inMessage, outMessage;

        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new ArraivalLoungeMessage (ArraivalLoungeMessage.WHAT_SHOULD_I_DO, goHome);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (ArraivalLoungeMessage) con.readObject ();
       
        if (inMessage.getMsgType() != ArraivalLoungeMessage.ACK)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

        
        
    }

    public void setParameters(int nrPassengers, List<List<Baggage>> bagsPerFlight) {

        ClientCom con = new ClientCom(serverHostName, serverPortNumb);
        ArraivalLoungeMessage inMessage, outMessage;

        while (!con.open()) // aguarda ligação
        {
            try {
                Thread.currentThread().sleep((long) (10));
            } catch (InterruptedException e) {
            }
        }

        outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.SET_PARAMETERS, nrPassengers, bagsPerFlight);
        con.writeObject(outMessage);
        inMessage = (ArraivalLoungeMessage) con.readObject();
        if (inMessage.getMsgType() != ArraivalLoungeMessage.ACK) {
            System.out.println("Arranque da simulação: Tipo inválido!");
            System.out.println(inMessage.toString());
            System.exit(1);
        }
        con.close();
    }


    @Override
    public void endOfDay() {
        
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ArraivalLoungeMessage inMessage, outMessage;

        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new ArraivalLoungeMessage (ArraivalLoungeMessage.END_OF_DAY);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (ArraivalLoungeMessage) con.readObject ();
       
        if (inMessage.getMsgType() != ArraivalLoungeMessage.ACK)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }
    
}