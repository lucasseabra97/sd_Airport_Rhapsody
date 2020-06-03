package serverSide.serverAL;


import commonInfra.*;
public class ArraivalLoungeInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private ArraivalLounge monitorAL;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorAL
     */

   public ArraivalLoungeInterface(ArraivalLounge monitorAL){
       this.monitorAL = monitorAL;
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

  public ArraivalLoungeMessage processAndReply (ArraivalLoungeMessage inMessage) throws ALMessageException
  {
    ArraivalLoungeMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case ArraivalLoungeMessage.WHAT_SHOULD_I_DO: 
            break;
        case ArraivalLoungeMessage.TRY_TO_COLLECCT_A_BAG:
            break;
        case ArraivalLoungeMessage.TAKE_A_REST:
            break;
        case ArraivalLoungeMessage.SET_PARAMETERS:
            if (inMessage.getNPass() <= 0)
                throw new ALMessageException ("Numero de passageiros inexistente!", inMessage);
            if (inMessage.getBagsList() == null || inMessage.getBagsList().size() == 0)
                throw new ALMessageException ("Malas inexistentes!", inMessage);
            break;
        
        case ArraivalLoungeMessage.END_OF_DAY:
            break;
        
        default:
            throw new ALMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ArraivalLoungeMessage.WHAT_SHOULD_I_DO:                         
                    monitorAL.whatShouldIDO(inMessage.isGoHome());
                    outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.ACK);
                    break;                    
        case ArraivalLoungeMessage.TRY_TO_COLLECCT_A_BAG:
                    Baggage bag = monitorAL.tryToCollectABag();
                    outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.ACK ,bag );
                    break;                               
        case ArraivalLoungeMessage.TAKE_A_REST:
                    boolean takeRest = monitorAL.takeARest();
                    outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.ACK , takeRest);
                    break;  
        case ArraivalLoungeMessage.SET_PARAMETERS:
                    monitorAL.setParameters(inMessage.getNPass(), inMessage.getBagsList());
                    outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.ACK);
                    break;
        case ArraivalLoungeMessage.END_OF_DAY:
                    monitorAL.endOfDay();
                    outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.ACK);
                    break;                             
            
     }
    return (outMessage);
   }
}