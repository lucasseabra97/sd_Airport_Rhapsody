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
        case ArraivalLoungeMessage.REQ_WHAT_SHOULD_I_DO:
        case ArraivalLoungeMessage.REQ_TRY_TO_COLLECCT_A_BAG:
        case ArraivalLoungeMessage.REQ_TAKE_A_REST:
        case ArraivalLoungeMessage.END_OF_DAY_DONE:
        default:
             throw new ALMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ArraivalLoungeMessage.REQ_WHAT_SHOULD_I_DO:                         
                    int nPass = monitorAL.whatShouldIDO(inMessage.isGoHome());
                    outMessage = new ArraivalLoungeMessage(ArraivalLoungeMessage.WHAT_SHOULD_I_DO_DONE,nPass);
                    break;                    
        case ArraivalLoungeMessage.REQ_TRY_TO_COLLECCT_A_BAG:
                    break;                               
        case ArraivalLoungeMessage.REQ_TAKE_A_REST:
                    break;                              
        case ArraivalLoungeMessage.END_OF_DAY_DONE:
                    break;                             
              
     }
     
    return (outMessage);
   }
}