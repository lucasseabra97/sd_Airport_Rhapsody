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
        case ATTQMessage.DEPARTURE_TIME:
            break;
        case ATTQMessage.TAKE_A_BUS:
            break;
        case ATTQMessage.ENTER_THE_BUS:
            break;
        case ATTQMessage.HAS_DAYS_WORK_ENDED:
            break;
        case ATTQMessage.ANNOUNCING_BUS_BOARDING:
            break;
        case ATTQMessage.END_OF_DAY:
            break; 
        default:
             throw new ATTQMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ATTQMessage.DEPARTURE_TIME:                         
                    monitorATTQ.departureTime();
                    outMessage = new ATTQMessage(ATTQMessage.ACK);
                    break;                    
        case ATTQMessage.TAKE_A_BUS:
                    monitorATTQ.takeABus(inMessage.getPassengerID());
                    outMessage = new ATTQMessage(ATTQMessage.ACK);
                    break;                               
        case ATTQMessage.ENTER_THE_BUS:
                    monitorATTQ.enterTheBus(inMessage.getPassengerID());
                    outMessage = new ATTQMessage(ATTQMessage.ACK);
                    break;                              
        case ATTQMessage.HAS_DAYS_WORK_ENDED:
                    BusDriverAction busDAction= monitorATTQ.hasDaysWorkEnded();
                    outMessage = new ATTQMessage(ATTQMessage.ACK,busDAction);
                    break;                             
        case ATTQMessage.ANNOUNCING_BUS_BOARDING:
                    int insidePassengers = monitorATTQ.annoucingBusBoarding();
                    outMessage = new ATTQMessage(ATTQMessage.ACK , insidePassengers);
                    break;
        case ATTQMessage.END_OF_DAY:
                    monitorATTQ.endOfDay();
                    outMessage = new ATTQMessage(ATTQMessage.ACK);
                    break;  
                
                
    }
     
    return (outMessage);
   }
}