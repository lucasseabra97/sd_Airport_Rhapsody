package clientSide;

import java.util.ArrayList;

import commonInfra.DTTQMessage;
import commonInfra.Baggage;
import interfaces.IDepartureTerminalTransferQBusDriver;
import interfaces.IDepartureTerminalTransferQPassenger;

public class DepartureTerminalTransferQuayStub implements IDepartureTerminalTransferQPassenger , IDepartureTerminalTransferQBusDriver   {


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
    
    public DepartureTerminalTransferQuayStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }

    @Override
    public void leaveTheBus() {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTTQMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new DTTQMessage(DTTQMessage.REQ_LEAVE_THE_BUS);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (DTTQMessage) con.readObject ();
       
        if (inMessage.getMsgType() != DTTQMessage.LEAVE_THE_BUS_DONE)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }

    @Override
    public void waitRide() {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTTQMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new DTTQMessage(DTTQMessage.REQ_WAIT_RIDE);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (DTTQMessage) con.readObject ();
       
        if (inMessage.getMsgType() != DTTQMessage.WAIT_RIDE_DONE)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }

    @Override
    public void parkTheBusAndLetPassOff(int nPassenger) {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        DTTQMessage inMessage, outMessage;
    
        while (!con.open ())                                      // aguarda ligação
        { try
            { Thread.currentThread ().sleep ((long) (10));
            }
            catch (InterruptedException e) {}
        }
        outMessage = new DTTQMessage(DTTQMessage.REQ_PARK_THE_BUS_AND_LET_PASS_OFF,nPassenger);    // o barbeiro chama o cliente
        con.writeObject (outMessage);
        inMessage = (DTTQMessage) con.readObject ();
       
        if (inMessage.getMsgType() != DTTQMessage.PARK_THE_BUS_AND_LET_PASS_OFF_DONE)
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }


}