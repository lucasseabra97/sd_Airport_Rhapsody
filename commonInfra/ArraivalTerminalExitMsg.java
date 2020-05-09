package commonInfra;

import java.io.Serializable;

public class ArraivalLoungeMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests for what to do when arraives at the airport (pedido passageiro)
     */
    public static final int REQ_GO_HOME = 1;

    /**
    *  What Should I Do request was sent to the server (resposta enviada pelo servidor)
    */
    public static final int GO_HOME_DONE = 2;

   /**
    * Porter asks for take a rest (pedido do porteiro)
    */

    public static final int REQ_AWAKE_PASSENGERS = 3;
    /** 
     *  Request for take a rest was sent to the server (resposta enviada pelo servidor)
     */

    public static final int AWAKE_PASSENGERS_DONE = 4;
    /**
     *  Porter requests to try to collect a bag (pedido do porteiro)
    */

    public static final int REQ_N_PASSENGERS_DEPARTURE_AT = 5;
    /**
     *  Request for try to collect a bag was sent (resposta enviada pelo servidor)
     */

    public static final int N_PASSENGERS_DEPARTURE_AT_DONE = 6;
    /**
     *  Passenger alerts Porter to end of day (pedido do passageiro)
    */

    public static final int REQ_SYNC_PASSENGER= 7;
    /**
     *  Alert was sent sucessufly (resposta do servidor)
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
     * retorna o numero de passageiros -> whatshouldIDo
     */
    private int nPass;

    /**
     * 
     * @param msgType
     * @param goHome
     */
    public ArraivalLoungeMessage(int msgType,boolean goHome){
        this.msgType = msgType;
        this.goHome = goHome;
    }

    public ArraivalLoungeMessage(int msgType){
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

    public ArraivalLoungeMessage(int msgType,int nPass){
        this.msgType = msgType ;
        this.nPass   = nPass;
    }     

    @Override
    public String toString() {
        return "{" +
            " msgType='" + getMsgType() + "'" +
            ", goHome='" + isGoHome() + "'" +
            "}";
    }

}   