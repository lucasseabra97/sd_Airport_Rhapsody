package serverSide.serverATTQ;


import commonInfra.*;
public class ArraivalTerminalTransferQuayInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private ArraivalTerminalTransferQuay monitorATTQ;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorATE
     */

   public ArraivalTerminalTransferQuayInterface(ArraivalTerminalTransferQuay monitorATTQ){
       this.monitorATTQ = monitorATTQ;
   }

   /**
   *  Processamento das mensagens através da execução da tarefa correspondente.
   *  Geração de uma mensagem de resposta.
   *
   *    @param inMessage mensagem com o pedido
   *
   *    @return mensagem de resposta
   *
   *    @throws MessageException se a mensagem com o pedido for considerada inválida
   */

  public ATTQMessage processAndReply (ATTQMessage inMessage) throws ATTQMessageException
  {
    ATTQMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case ATTQMessage.REQ_DEPARTURE_TIME:
            break;
        case ATTQMessage.REQ_TAKE_A_BUS:
            break;
        case ATTQMessage.REQ_ENTER_THE_BUS:
            break;
        case ATTQMessage.REQ_HAS_DAYS_WORK_ENDED:
            break;
        case ATTQMessage.REQ_ANNOUNCING_BUS_BOARDING:
            break;
        case ATTQMessage.REQ_END_OF_DAY:
            break; 
        default:
             throw new ATTQMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ATTQMessage.REQ_DEPARTURE_TIME:                         
                    monitorATTQ.departureTime();
                    outMessage = new ATTQMessage(ATTQMessage.DEPARTURE_TIME_DONE);
                    break;                    
        case ATTQMessage.REQ_TAKE_A_BUS:
                    monitorATTQ.takeABus(inMessage.getPassengerID());
                    outMessage = new ATTQMessage(ATTQMessage.TAKE_A_BUS_DONE);
                    break;                               
        case ATTQMessage.REQ_ENTER_THE_BUS:
                    monitorATTQ.enterTheBus(inMessage.getPassengerID());
                    outMessage = new ATTQMessage(ATTQMessage.ENTER_THE_BUS_DONE);
                    break;                              
        case ATTQMessage.REQ_HAS_DAYS_WORK_ENDED:
                    BusDriverAction busDAction= monitorATTQ.hasDaysWorkEnded();
                    outMessage = new ATTQMessage(ATTQMessage.HAS_DAYS_WORK_ENDED_DONE,busDAction);
                    break;                             
        case ATTQMessage.REQ_ANNOUNCING_BUS_BOARDING:
                    int insidePassengers = monitorATTQ.annoucingBusBoarding();
                    outMessage = new ATTQMessage(ATTQMessage.ANNOUNCING_BUS_BOARDING_DONE , insidePassengers);
                    break;
        case ATTQMessage.REQ_END_OF_DAY:
                    monitorATTQ.endOfDay();
                    outMessage = new ATTQMessage(ATTQMessage.END_OF_DAY_DONE);
                    break;  
                
                
    }
     
    return (outMessage);
   }
}