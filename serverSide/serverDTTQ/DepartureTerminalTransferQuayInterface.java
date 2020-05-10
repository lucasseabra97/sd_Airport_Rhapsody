
package serverSide.serverDTTQ;


import commonInfra.*;
public class DepartureTerminalTransferQuayInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private DepartureTerminalTransferQuay monitorDTTQ;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorATE
     */

   public DepartureTerminalTransferQuayInterface(DepartureTerminalTransferQuay monitorDTTQ){
       this.monitorDTTQ = monitorDTTQ;
   }

   /**
    * Processamento das mensagens através da execução da tarefa correspondente.
    * Geração de uma mensagem de resposta.
    *
    * @param inMessage mensagem com o pedido
    *
    * @return mensagem de resposta
    * @throws DTTQMessageException
    *
    * @throws MessageException    se a mensagem com o pedido for considerada
    *                             inválida
    */

   public DTTQMessage processAndReply(DTTQMessage inMessage) throws DTTQMessageException
  {
    DTTQMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case DTTQMessage.REQ_WAIT_RIDE:
            break;
        case DTTQMessage.REQ_LEAVE_THE_BUS:
            break;
        case DTTQMessage.REQ_PARK_THE_BUS_AND_LET_PASS_OFF:
            break;
        default:
             throw new DTTQMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case DTTQMessage.REQ_WAIT_RIDE:
                    monitorDTTQ.waitRide();
                    outMessage = new DTTQMessage(DTTQMessage.WAIT_RIDE_DONE);
                    break;
        case DTTQMessage.REQ_LEAVE_THE_BUS:
                    monitorDTTQ.leaveTheBus();
                    outMessage = new DTTQMessage(DTTQMessage.LEAVE_THE_BUS_DONE);
                    break;
        case DTTQMessage.REQ_PARK_THE_BUS_AND_LET_PASS_OFF:
                    monitorDTTQ.parkTheBusAndLetPassOff(inMessage.getPassengersLeaving());                                           
                    outMessage = new DTTQMessage(DTTQMessage.PARK_THE_BUS_AND_LET_PASS_OFF_DONE );
                    break; 
    }
    return (outMessage);
   }
}