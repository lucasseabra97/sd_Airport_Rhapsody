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
        case ATEMessage.GO_HOME:
              break;
        case ATEMessage.AWAKE_PASSENGERS:
              break;
        case ATEMessage.N_PASSENGERS_DEPARTURE_AT:
              break;
        case ATEMessage.SYNC_PASSENGER:
              break;
        case ATEMessage.SHUTDOWN:
              break;
      case ATEMessage.SET_PARAM:
            if (inMessage.getNPassGoingHome() <= 0)
                  throw new ATEMessageException("Numero de passageiros inexistente!", inMessage);
            break;
        // case ArraivalLoungeMessage.END_OF_DAY_DONE:                         //necessário end of day para cada server ? 
        default:
             throw new ATEMessageException("Tipo inválido!", inMessage);
     }

     /* seu processamento */

     switch (inMessage.getMsgType())
     {
        case ATEMessage.GO_HOME:                         
                    boolean goHome = monitorATE.goHome(inMessage.getNPassGoingHome());
                    outMessage = new ATEMessage(ATEMessage.ACK,goHome);
                    break;                    
        case ATEMessage.AWAKE_PASSENGERS:
                    monitorATE.awakePassengers();
                    outMessage = new ATEMessage(ATEMessage.ACK);
                    break;                               
        case ATEMessage.N_PASSENGERS_DEPARTURE_AT:
                    int nPass = monitorATE.nPassengersDepartureAT();
                    outMessage = new ATEMessage(ATEMessage.ACK , nPass);
                    break;   
        case ATEMessage.SET_PARAM:
                    monitorATE.setParameters(inMessage.getNPassGoingHome());
                    outMessage = new ATEMessage(ATEMessage.ACK);   
                    break;                    
        case ATEMessage.SYNC_PASSENGER:
                    monitorATE.syncPassenger();
                    outMessage = new ATEMessage(ATEMessage.ACK);
                    break;                             
        case ATEMessage.SHUTDOWN:
                    ArraivalTerminalExitMain.waitConnection = false;
                    (((Proxy) (Thread.currentThread())).getScon()).setTimeout(10);
                    outMessage = new ATEMessage(ATEMessage.ACK);
                    break;
     }
     
    return (outMessage);
   }
}