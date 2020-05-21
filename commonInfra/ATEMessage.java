package commonInfra;

import java.io.Serializable;

public class ATEMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests ??? (pedido passageiro)
     */
    public static final int REQ_GO_HOME = 1;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int GO_HOME_DONE = 2;

   /**
    *  pedido invocado pelo ultimo cliente na saida 
    */

    public static final int REQ_AWAKE_PASSENGERS = 3;
    /** 
     *   (resposta enviada pelo servidor)
     */

    public static final int AWAKE_PASSENGERS_DONE = 4;
    /**
     *   (pedido do porteiro)
    */

    public static final int REQ_N_PASSENGERS_DEPARTURE_AT = 5;
    /**
     *   (resposta enviada pelo servidor)
     */

    public static final int N_PASSENGERS_DEPARTURE_AT_DONE = 6;
    /**
     *  (pedido do passageiro)
    */

    public static final int REQ_SYNC_PASSENGER= 7;
    /**
     *   (resposta do servidor)
     */

    public static final int SYNC_PASSENGER_DONE = 8;

    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    
    /**
    *  verifica se o passageiro vai para casa ou tempo outro voo 
    */
    
    private boolean goHome;
    /**
     * retorna o numero de passageiros que querem ir para casa
     */
    private int nPassGoingHome;
    /**
     * Returns all passengers in Arraival Terminal Exit
     */
    private int nPassengersDepartureAT;
    
    /**
     * 
     * @param msgType
     * @param goHome
     */
    public ATEMessage(int msgType, int nPass){
        this.msgType = msgType;
        if((msgType == GO_HOME_DONE))
            this.nPassGoingHome = nPass;
        else
            this.nPassengersDepartureAT=nPass; 
    }

    public ATEMessage(int msgType , boolean goHome){
        this.msgType = msgType;
        this.goHome = goHome;
    }

    public ATEMessage(int msgType){
        this.msgType = msgType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public boolean getGoHome() {
        return this.goHome;
    }

    public boolean isGoHome() {
        return this.goHome;
    }

    public int getNPassGoingHome() {
        return this.nPassGoingHome;
    }

    public int getNPassengersDepartureAT() {
        return this.nPassengersDepartureAT;
    }


    @Override
    public String toString() {
        return "{" +
            " msgType='" + getMsgType() + "'" +
            ", goHome='" + isGoHome() + "'" +
            ", nPassGoingHome='" + getNPassGoingHome() + "'" +
            ", nPassengersDepartureAT='" + getNPassengersDepartureAT() + "'" +
            "}";
    }

}   