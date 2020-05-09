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
    public static final int REQ_DEPARTURE_TIME = 1;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int DEPARTURE_TIME_DONE = 2;

   /**
    *  pedido invocado pelo ultimo cliente na saida 
    */

    public static final int REQ_TAKE_A_BUS = 3;
    /** 
     *   (resposta enviada pelo servidor)
     */

    public static final int TAKE_A_BUS_DONE = 4;
    /**
     *   (pedido do porteiro)
    */

    public static final int REQ_ENTER_THE_BUS = 5;
    /**
     *   (resposta enviada pelo servidor)
     */

    public static final int ENTER_THE_BUS_DONE = 6;
    /**
     *  (pedido do passageiro)
    */

    public static final int REQ_HAS_DAYS_WORK_ENDED= 7;
    /**
     *   (resposta do servidor)
     */

    public static final int HAS_DAYS_WORK_ENDED_DONE = 8;

    /**
     * (pedido do bus driver)
     */
    public static final int REQ_ANNOUNCING_BUS_BOARDING= 9;
    /**
     *   
     */

    public static final int ANNOUNCING_BUS_BOARDING_DONE = 10;
    /**
    *  (resposta do servidor)
    */   
    public static final int REQ_END_OF_DAY = 11;
    /**
    *  
    */ 
    public static final int END_OF_DAY_DONE =12;


    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    /**
     * retorna o numero de passageiros
     */
    private int insidePass;

    private int passengerID;
    

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

    

    public ATTQMessage(int msgType , int insidePass){
        this.msgType = msgType;
        this.insidePass = insidePass;
    }

    public ATTQMessage(int msgType){
        this.msgType = msgType;
    }


    public int getMsgType() {
        return this.msgType;
    }

    public int getInsidePass() {
        return this.insidePass;
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
            " msgType='" + getMsgType() + "'" +
            ", insidePass='" + getInsidePass() + "'" +
            ", passengerID='" + getPassengerID() + "'" +
            ", busDAction='" + getBusDAction() + "'" +
            "}";
    }


}   