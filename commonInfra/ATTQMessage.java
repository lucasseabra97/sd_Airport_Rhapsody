package commonInfra;

import java.io.Serializable;

public class ATTQMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests ??? (pedido passageiro)
     */
    public static final int DEPARTURE_TIME = 1;

   /**
    *  pedido invocado pelo ultimo cliente na saida 
    */

    public static final int TAKE_A_BUS = 2;
   
    /**
     *   (pedido do porteiro)
    */

    public static final int ENTER_THE_BUS = 3;
    /**
     *  (pedido do passageiro)
    */

    public static final int HAS_DAYS_WORK_ENDED= 4;

    /**
     * (pedido do bus driver)
     */
    public static final int ANNOUNCING_BUS_BOARDING= 5;
    /**
    *  (resposta do servidor)
    */   
    public static final int END_OF_DAY = 6;
    /**
    *  
    */ 
    public static final int ACK = 7;


    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    /**
     * retorna o numero de passageiros
     */
    private int insidePass;
    /**
     *  Retorna o ID do passageiro
     */
    private int passengerID;
    
    /**
     *  Retorna a acao que o busDriver vai executar
     */
    private BusDriverAction busDAction;

    /**
     * Constructor 
     * @param msgType
     * @param busDAction
     */
    public ATTQMessage(int msgType, BusDriverAction busDAction){
        this.msgType = msgType;
        this.busDAction = busDAction;
    }


    public ATTQMessage(int msgType , int passengerID){
        this.msgType = msgType;
        // if(msgType == ENTER_THE_BUS || msgType == TAKE_A_BUS){
        //     this.passengerID = passengerInfo;
        // }else{
        //     this.insidePass = passengerInfo;
        // }
        this.passengerID = passengerID;
        
    }

    public ATTQMessage(int msgType){
        this.msgType = msgType;
    }



    public int getMsgType() {
        return this.msgType;
    }

    public int getPassengerID() {
        return this.passengerID;
    }

    public BusDriverAction getBusDAction() {
        return this.busDAction;
    }
    
    

    @Override
    public String toString() {
        return "{" +
            " msgType='" + msgType + "'" +
            ", passengerID='" + passengerID + "'" +
            ", busDAction='" + busDAction + "'" +
            "}";
    }
    


}   