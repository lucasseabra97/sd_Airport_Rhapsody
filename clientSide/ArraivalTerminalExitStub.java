package clientSide;

import commonInfra.ATEMessage;
import interfaces.IArraivalTerminalExitPassenger;

public class ArraivalTerminalExitStub implements IArraivalTerminalExitPassenger {

     
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

    public ArraivalTerminalExitStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }


    @Override
    public boolean goHome(int npassengers) {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATEMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATEMessage (ATEMessage.REQ_GO_HOME,npassengers);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATEMessage) con.readObject ();

        if ((inMessage.getMsgType() != ATEMessage.GO_HOME_DONE))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        
        //if(inMessage.getMsgType()==ATEMessage.GO_HOME_DONE)
            return inMessage.isGoHome();
        
    }

    @Override
    public void syncPassenger() {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATEMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATEMessage (ATEMessage.REQ_SYNC_PASSENGER);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATEMessage) con.readObject ();

        if ((inMessage.getMsgType() != ATEMessage.SYNC_PASSENGER_DONE))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();

    }

    @Override
    public int nPassengersDepartureAT() {
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATEMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATEMessage (ATEMessage.REQ_N_PASSENGERS_DEPARTURE_AT);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATEMessage) con.readObject ();

        if ((inMessage.getMsgType() != ATEMessage.N_PASSENGERS_DEPARTURE_AT_DONE))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
        return inMessage.getNPassengersDepartureAT();
    }

    @Override
    public void awakePassengers() {
       
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        ATEMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new ATEMessage (ATEMessage.REQ_AWAKE_PASSENGERS);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (ATEMessage) con.readObject ();

        if ((inMessage.getMsgType() != ATEMessage.AWAKE_PASSENGERS_DONE))
            {   System.out.println("Thread " + Thread.currentThread ().getName () + ": Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }
    
}