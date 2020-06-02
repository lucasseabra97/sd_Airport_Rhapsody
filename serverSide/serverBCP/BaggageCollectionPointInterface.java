package serverSide.serverBCP;
import commonInfra.*;
public class BaggageCollectionPointInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private BaggageCollectionPoint monitorBCP;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorATE
     */

   public BaggageCollectionPointInterface(BaggageCollectionPoint monitorBCP){
       this.monitorBCP = monitorBCP;
   }

   /**
    * Processamento das mensagens através da execução da tarefa correspondente.
    * Geração de uma mensagem de resposta.
    *
    * @param inMessage mensagem com o pedido
    *
    * @return mensagem de resposta
    * @throws BCPMessageException
    *
    * @throws MessageException    se a mensagem com o pedido for considerada
    *                             inválida
    */

   public BCPMessage processAndReply(BCPMessage inMessage) throws BCPMessageException
  {
    BCPMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case BCPMessage.CARRY_IT_TO_APPROPRIATE_STORE:
            if(inMessage.getBaggage() == null)
            throw new BCPMessageException ("Mala inexistente!", inMessage);
            break;
        case BCPMessage.GO_COLLECT_A_BAG:
            if(inMessage.getBaggageList() == null || inMessage.getBaggageList().size() == 0)
            throw new BCPMessageException ("Set de IDS das malas do utilizador inválido ou vazio", inMessage);
            break;
        case BCPMessage.NO_MORE_BAGS_TO_COLLECT:
            break;
        case BCPMessage.RESET_STATE:
            break;
        default:
             throw new BCPMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case BCPMessage.CARRY_IT_TO_APPROPRIATE_STORE:
                    monitorBCP.carryItToAppropriateStore(inMessage.getBaggage());
                    outMessage = new BCPMessage(BCPMessage.ACK);
                    break;                    
        case BCPMessage.GO_COLLECT_A_BAG:
                    Baggage bag = monitorBCP.goCollectABag(inMessage.getBaggageList());
                    //if(bag == null) System.out.println("no bags in BCP");
                    outMessage = new BCPMessage(BCPMessage.ACK , bag);
                    break;                               
        case BCPMessage.NO_MORE_BAGS_TO_COLLECT:
                    monitorBCP.noMoreBagsToCollect();
                    outMessage = new BCPMessage(BCPMessage.ACK);
                    break;                              
        case BCPMessage.RESET_STATE:
                    monitorBCP.resetState();
                    outMessage = new BCPMessage(BCPMessage.ACK);                         
                    break;                             
    }
     
    return (outMessage);
   }
}