package serverSide.serverATE;


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

  public ATEMessage processAndReply (ATEMessage inMessage) throws ATEMessageException
  {
    ATEMessage outMessage = null;                           // mensagem de resposta

    /* validação da mensagem recebida */

     switch (inMessage.getMsgType()) 
     {
        case ATEMessage.REQ_GO_HOME:
              break;
        case ATEMessage.REQ_AWAKE_PASSENGERS:
              break;
        case ATEMessage.REQ_N_PASSENGERS_DEPARTURE_AT:
              break;
        case ATEMessage.REQ_SYNC_PASSENGER:
              break;
        // case ArraivalLoungeMessage.END_OF_DAY_DONE:                         //necessário end of day para cada server ? 
        default:
             throw new ATEMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ATEMessage.REQ_GO_HOME:                         
                    boolean goHome = monitorATE.goHome(inMessage.getNPassGoingHome());
                    outMessage = new ATEMessage(ATEMessage.GO_HOME_DONE,goHome);
                    break;                    
        case ATEMessage.REQ_AWAKE_PASSENGERS:
                    monitorATE.awakePassengers();
                    outMessage = new ATEMessage(ATEMessage.AWAKE_PASSENGERS_DONE);
                    break;                               
        case ATEMessage.REQ_N_PASSENGERS_DEPARTURE_AT:
                    int nPass = monitorATE.nPassengersDepartureAT();
                    outMessage = new ATEMessage(ATEMessage.N_PASSENGERS_DEPARTURE_AT_DONE);
                    break;                              
        case ATEMessage.REQ_SYNC_PASSENGER:
                    monitorATE.syncPassenger();
                    outMessage = new ATEMessage(ATEMessage.SYNC_PASSENGER_DONE);
                    break;                             
              
     }
     
    return (outMessage);
   }
}