package serverSide.serverAL;


import commonInfra.*;
public class ArraivalTerminalExitInterface {
    /**
   *  Barbearia (representa o serviço a ser prestado)
   *
   *    @serialField bShop
   */

   private ArraivalTerminalExit monitorATE;
    /**
     * Instanciação do interface ao Arraival Lounge.
     * @param monitorATE
     */

   public ArraivalTerminalExitInterface(ArraivalTerminalExit monitorATE){
       this.monitorATE = monitorATE;
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

  public ArraivalTerminalExitMessage processAndReply (ArraivalTerminalExitMessage inMessage) throws ATEMessageException
  {
    ArraivalTerminalExitMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case ArraivalTerminalExitMessage.REQ_GO_HOME:
        case ArraivalTerminalExitMessage.REQ_AWAKE_PASSENGERS:
        case ArraivalTerminalExitMessage.REQ_N_PASSENGERS_DEPARTURE_AT:
        case ArraivalTerminalExitMessage.REQ_SYNC_PASSENGER:
        // case ArraivalLoungeMessage.END_OF_DAY_DONE:                         //necessário end of day para cada server ? 
        default:
             throw new ATEMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ArraivalTerminalExitMessage.REQ_GO_HOME:                         
                    boolean goHome = monitorATE.goHome(inMessage.isGoHome());
                    outMessage = new ArraivalTerminalExitMessage(ArraivalTerminalExitMessage.GO_HOME_DONE,goHome);
                    break;                    
        case ArraivalTerminalExitMessage.REQ_AWAKE_PASSENGERS:
                    monitorATE.awakePassengers
                    break;                               
        case ArraivalTerminalExitMessage.REQ_N_PASSENGERS_DEPARTURE_AT:
                    break;                              
        case ArraivalTerminalExitMessage.REQ_SYNC_PASSENGER:
                    break;                             
              
     }
     
    return (outMessage);
   }
}