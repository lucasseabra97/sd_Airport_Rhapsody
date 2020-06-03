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
    public static final int GO_HOME = 1;

   /**
    *  pedido invocado pelo ultimo cliente na saida 
    */

    public static final int AWAKE_PASSENGERS = 2;
 
    /**
     *   (pedido do porteiro)
    */

    public static final int N_PASSENGERS_DEPARTURE_AT = 3;

    /**
     *  (pedido do passageiro)
    */

    public static final int SYNC_PASSENGER= 4;
    /**
     *   (resposta do servidor)
     */
    /**
     * 
     */
    public static final int SET_PARAM = 5;
    /**
     *  
     */
    public static final int ACK = 6;

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
        if((msgType ==ACK))
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