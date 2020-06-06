package clientSide.stubs;

import clientSide.ClientCom;
import commonInfra.GRMessage;
import commonInfra.PassengerEnum;

public class GeneralRepositoryStub {
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
    public GeneralRepositoryStub(String serverHostName,int serverPortNumb){
        this.serverHostName = serverHostName;
        this.serverPortNumb = serverPortNumb;
    }
    
    public void addFinalDestinations(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.ADD_FINAL_DESTINATIONS);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() != GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void addTransit(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.ADD_TRANSIT);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() != GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void startNextFlight(int flightLuggage){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.START_NEXT_FLIGHT,flightLuggage);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passengerInit(PassengerEnum state, int bags, String situation ,int id){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_INIT,state,bags,situation,id);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void porterWaitingLanding(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PORTER_WAITING_LANDING);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void addBag(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.ADD_BAG);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void porterCollectBag(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PORTER_COLLECT_BAG);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passGoHome(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_GO_HOME);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passJoinBusQueue(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_JOIN_BUS_QUEUE,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passSitInBus(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_SIT_IN_BUS,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void driverParkingArrivalTerminal(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.DRIVER_PARKING_ARRIVAL_TERMINAL,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void driverDrivingForward(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.DRIVER_DRIVING_FOWARD);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void porterMoveBagToConveyorBelt(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PORTER_MOVE_BAG_TO_CONVEYOR_BELT);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passEnterLuggageCollectionPoint(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_ENTER_LUGGAGE_COLLECTIONPOINT,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passCollectBag(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_COLLECT_BAG,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void porterNoMoreBags(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PORTER_NO_MORE_BAGS);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
    }

    public void passComplain(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_COMPLAIN,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        
        con.close ();
        
    }

    public void passPrepareNextLeg(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_PREPARE_NEXT_LEG,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void passBusRide(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_BUS_RIDE,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void passLeaveBus(int passengerID){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PASSENGER_LEAVE_BUS,passengerID);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void driverParkingDepartureTerminal(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.DRIVER_PARKING_DEPARTURE_TERMINAL);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void driverDrivingBackward(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.DRIVER_DRIVING_BACKWARD);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void porterMoveBagToStoreroom(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.PORTER_MOVE_BAG_TO_STOREROOM);        // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void driverParkingArrivalTerminal(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.DRIVER_PARKING_ARRIVAL_TERMINAL);       // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }
    public void setParameters(int nrPassenger, int busSize){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.SET_PARAMETERS,nrPassenger,busSize);       // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

    public void shutdown(){
        ClientCom con = new ClientCom (serverHostName, serverPortNumb);
        GRMessage inMessage, outMessage;

        while (!con.open ())                                  // aguarda ligação
            { try
                { Thread.currentThread ().sleep ((long) (10));
                }
                catch (InterruptedException e) {}
            }
        outMessage = new GRMessage (GRMessage.SHUTDOWN);       // pede a realização do serviço
        con.writeObject (outMessage);
        inMessage = (GRMessage)con.readObject();

        if (inMessage.getMsgType() !=GRMessage.ACK)
            {   System.out.println(" Tipo inválido!");
                System.out.println(inMessage.toString ());
                System.exit (1);
            }
        con.close ();
    }

}