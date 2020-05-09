package serverSide.serverBRO;


import commonInfra.*;
public class BaggageReclaimOfficeInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private BaggageReclaimOffice monitorBRO;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorATE
     */

   public BaggageReclaimOfficeInterface(BaggageReclaimOffice monitorBRO){
       this.monitorBRO = monitorBRO;
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

   public BROMessage processAndReply(BROMessage inMessage) throws BROMessageException
  {
    BROMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case BROMessage.REQ_COMPLAIN:
            break;
        default:
             throw new BROMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case BROMessage.REQ_COMPLAIN:
                    monitorBRO.complain(inMessage.getBaggageList());
                    outMessage = new BROMessage(BROMessage.COMPLAIN_DONE);
                    break;                                                 
    }
    return (outMessage);
   }
}