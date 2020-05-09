package serverSide.serverDTE;


import commonInfra.*;
public class DepartureTerminalEntranceInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private DepartureTerminalEntrance monitorDTE;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorATE
     */

   public DepartureTerminalEntranceInterface(DepartureTerminalEntrance monitorDTE){
       this.monitorDTE = monitorDTE;
   }

   /**
    * Processamento das mensagens através da execução da tarefa correspondente.
    * Geração de uma mensagem de resposta.
    *
    * @param inMessage mensagem com o pedido
    *
    * @return mensagem de resposta
    * @throws BROMessageException
    *
    * @throws MessageException    se a mensagem com o pedido for considerada
    *                             inválida
    */

   public DTEMessage processAndReply(DTEMessage inMessage) throws DTEMessageException
  {
    DTEMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case DTEMessage.REQ_SYNC_PASSENGER:
            break;
        case DTEMessage.REQ_AWAKE_PASSENGERS:
            break;
        case DTEMessage.REQ_N_PASSENGERS_DEPARTURE_TENTRANCE:
            break;
        case DTEMessage.REQ_PREPARE_NEXT_LEG:
            break;
        default:
             throw new DTEMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case DTEMessage.REQ_SYNC_PASSENGER:
                    monitorDTE.syncPassenger();
                    outMessage = new DTEMessage(DTEMessage.SYNC_PASSENGER_DONE);
                    break;
        case DTEMessage.REQ_AWAKE_PASSENGERS:
                    monitorDTE.awakePassengers();
                    outMessage = new DTEMessage(DTEMessage.AWAKE_PASSENGERS_DONE);
                    break;
        case DTEMessage.REQ_N_PASSENGERS_DEPARTURE_TENTRANCE:
                    int nPassenger = monitorDTE.nPassengersDepartureTEntrance();                                           
                    outMessage = new DTEMessage(DTEMessage.N_PASSENGERS_DEPARTURE_TENTRANCE_DONE , nPassenger);
                    break;
        case DTEMessage.REQ_PREPARE_NEXT_LEG:
                    boolean lastPassenger = monitorDTE.prepareNextLeg(inMessage.lastPassenger());
                    outMessage = new DTEMessage(DTEMessage.PREPARE_NEXT_LEG_DONE,lastPassenger);
                    break;
    }
    return (outMessage);
   }
}