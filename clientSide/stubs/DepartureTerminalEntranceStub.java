package clientSide.stubs;

import java.util.ArrayList;

import clientSide.ClientCom;
import commonInfra.DTEMessage;
import commonInfra.Baggage;
import interfaces.IDepartureTerminalEntrancePassenger;

public class DepartureTerminalEntranceStub implements IDepartureTerminalEntrancePassenger   {


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
    
    public DepartureTerminalEntranceStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    @Override
    public void syncPassenger() {
    
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTEMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new DTEMessage(DTEMessage.SYNC_PASSENGER);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (DTEMessage) con.readObject ();
       
        if (inMessage.getMsgType() != DTEMessage.ACK)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }
    @Override
    public void awakePassengers(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTEMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new DTEMessage(DTEMessage.AWAKE_PASSENGERS);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (DTEMessage) con.readObject ();
       
        if (inMessage.getMsgType() != DTEMessage.ACK)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();


    }

    @Override
    public boolean prepareNextLeg(int npassengers) {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTEMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new DTEMessage (DTEMessage.PREPARE_NEXT_LEG,npassengers);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (DTEMessage) con.readObject ();

        if ((inMessage.getMsgType() !=DTEMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        return inMessage.lastPassenger();
    }

    @Override
    public int nPassengersDepartureTEntrance() {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTEMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new DTEMessage (DTEMessage.N_PASSENGERS_DEPARTURE_TENTRANCE);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (DTEMessage) con.readObject ();

        if ((inMessage.getMsgType() !=DTEMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        return inMessage.nPassenger();
    }


}