package clientSide.stubs;

import clientSide.ClientCom;
import commonInfra.ATTQMessage;
import commonInfra.BusDriverAction;
import commonInfra.DTTQMessage;
import interfaces.IArraivalTerminalTransferQBusDriver;
import interfaces.IArraivalTerminalTransferQPassenger;

public class ArrailvalTTransferQuayStub implements IArraivalTerminalTransferQPassenger, IArraivalTerminalTransferQBusDriver {
    
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

    public ArrailvalTTransferQuayStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }
    
    @Override
    public int annoucingBusBoarding() {

        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.ANNOUNCING_BUS_BOARDING);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        
        return inMessage.getInsidePassengers();
        
    }
   

    
    @Override
    public BusDriverAction hasDaysWorkEnded() {

        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.HAS_DAYS_WORK_ENDED);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        return inMessage.getBusDAction();
    }

    @Override
    public void takeABus(int passengerID) {
        
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.TAKE_A_BUS,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    @Override
    public void enterTheBus(int passengerID) {

        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.ENTER_THE_BUS,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    @Override
    public void endOfDay() {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.END_OF_DAY);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }

    public void setParameters(int busSize){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.SET_PARAM,busSize);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }
    public void shutdown(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATTQMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATTQMessage (ATTQMessage.SHUTDOWN);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATTQMessage) con.readObject ();

        if ((inMessage.getMsgType() !=ATTQMessage.ACK))
            {   System.out.println("Thread " + Thread.currentThread().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }
    
}