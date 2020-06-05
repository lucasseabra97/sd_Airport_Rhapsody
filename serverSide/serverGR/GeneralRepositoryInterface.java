package serverSide.serverGR;
import commonInfra.*;

public class GeneralRepositoryInterface {
      /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private GeneralRepository monitorGR;
   /**
    * Instanciação do interface ao Arraival Lounge.
    * @param monitorGR
    */
    public GeneralRepositoryInterface(GeneralRepository monitorGR){
        this.monitorGR = monitorGR;
    }

    /**
    * Processamento das mensagens através da execução da tarefa correspondente.
    * Geração de uma mensagem de resposta.
    *
    * @param inMessage mensagem com o pedido
    *
    * @return mensagem de resposta
    *
    * @throws MessageException    se a mensagem com o pedido for considerada
    *                             inválida
    */
   public GRMessage processAndReply(GRMessage inMessage) throws GRMessageException
   {
     GRMessage outMessage = null;                           // mensagem de resposta
     /* validação da mensagem recebida */
      switch (inMessage.getMsgType()) 
      {
        case GRMessage.DRIVER_PARKING_ARRIVAL_TERMINAL:
            break;
        case GRMessage.DRIVER_PARKING_DEPARTURE_TERMINAL :
            break;
        case GRMessage.DRIVER_DRIVING_FOWARD:
            break;
        case GRMessage.DRIVER_DRIVING_BACKWARD:
            break;
        case GRMessage.PORTER_WAITING_LANDING:
            break;
        case GRMessage.PORTER_NO_MORE_BAGS:
            break;
        case GRMessage.PORTER_COLLECT_BAG:
            break;
        case GRMessage.PORTER_MOVE_BAG_TO_CONVEYOR_BELT:
            break;
        case GRMessage.PORTER_MOVE_BAG_TO_STOREROOM:
            break;
        case GRMessage.PASSENGER_INIT:
            break;
        case GRMessage.PASSENGER_ENTER_LUGGAGE_COLLECTIONPOINT:
            break;
        case GRMessage.PASSENGER_COLLECT_BAG:
            break;
        case GRMessage.PASSENGER_COMPLAIN:
            break;
        case GRMessage.PASSENGER_JOIN_BUS_QUEUE:
            break;
        case GRMessage.PASSENGER_SIT_IN_BUS:
            break;
        case GRMessage.PASSENGER_BUS_RIDE:
            break;
        case GRMessage.PASSENGER_LEAVE_BUS:
            break;
        case GRMessage.PASSENGER_GO_HOME:
            break;
        case GRMessage.PASSENGER_PREPARE_NEXT_LEG:
            break;
        case GRMessage.START_NEXT_FLIGHT:
            break;
        case GRMessage.ADD_FINAL_DESTINATIONS:
            break;
        case GRMessage.ADD_TRANSIT:
            break;
        case GRMessage.ADD_BAG:
            break;
        case GRMessage.ADD_LOST_BAGS:
            break;
        case GRMessage.SHUTDOWN:
            break;
        
         default:
              throw new GRMessageException("Tipo inválido!", inMessage);
      }
      /* seu processamento */
      switch (inMessage.getMsgType())
      {
         case GRMessage.DRIVER_PARKING_ARRIVAL_TERMINAL:
                     monitorGR.driverParkingArrivalTerminal();
                     outMessage = new GRMessage(GRMessage.ACK);
                     break;
         case GRMessage.DRIVER_PARKING_DEPARTURE_TERMINAL:
                     monitorGR.driverParkingDepartureTerminal();
                     outMessage = new GRMessage(GRMessage.ACK);
                     break;
         case GRMessage.DRIVER_DRIVING_FOWARD:
                     monitorGR.porterWaitingLanding();                                           
                     outMessage = new GRMessage(GRMessage.ACK);
                     break; 
         case GRMessage.PORTER_WAITING_LANDING:
                    monitorGR.porterWaitingLanding();                                           
                    outMessage = new GRMessage(GRMessage.ACK);
                    break; 
         case GRMessage.PORTER_NO_MORE_BAGS:
                    monitorGR.porterNoMoreBags();                                           
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PORTER_COLLECT_BAG:
                    monitorGR.porterCollectBag();                                           
                    outMessage = new GRMessage(GRMessage.ACK);
                    break; 
         case GRMessage.PORTER_MOVE_BAG_TO_CONVEYOR_BELT:
                    monitorGR.porterMoveBagToConveyorBelt();
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PORTER_MOVE_BAG_TO_STOREROOM:
                    monitorGR.porterMoveBagToStoreroom();
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_INIT:
                    monitorGR.passengerInit(inMessage.getState(), inMessage.getBags(), inMessage.getSituation(), inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_ENTER_LUGGAGE_COLLECTIONPOINT:
                    monitorGR.passEnterLuggageCollectionPoint(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_COLLECT_BAG:
                    monitorGR.passCollectBag(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_COMPLAIN:
                    monitorGR.passComplain(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_JOIN_BUS_QUEUE:
                    monitorGR.passJoinBusQueue(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_SIT_IN_BUS:
                    monitorGR.passSitInBus(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_BUS_RIDE:
                    monitorGR.passBusRide(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_LEAVE_BUS:
                    monitorGR.passLeaveBus(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_GO_HOME:
                    monitorGR.passGoHome(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.PASSENGER_PREPARE_NEXT_LEG:
                    monitorGR.passPrepareNextLeg(inMessage.getId());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.START_NEXT_FLIGHT:
                    monitorGR.startNextFlight(inMessage.getFlightLuggage());
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.ADD_FINAL_DESTINATIONS:
                    monitorGR.addFinalDestinations();
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.ADD_TRANSIT:
                    monitorGR.addTransit();
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.ADD_BAG:
                    monitorGR.addBag();
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.ADD_LOST_BAGS:
                    monitorGR.addLostBag();
                    outMessage = new GRMessage(GRMessage.ACK);
                    break;
         case GRMessage.SHUTDOWN:
                     GeneralRepositoryMain.waitConnection = false;
                     (((Proxy) (Thread.currentThread())).getScon()).setTimeout(10);
                     outMessage = new GRMessage(GRMessage.ACK);
                     break; 
     }
     return (outMessage);
    }
}