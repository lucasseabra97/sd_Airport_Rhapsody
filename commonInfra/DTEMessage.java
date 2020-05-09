package commonInfra;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class DTEMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests ??? (pedido passageiro)
     */
    public static final int REQ_SYNC_PASSENGER = 1;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int SYNC_PASSENGER_DONE = 2;

    /**
     * passenger request to awake passengers 
     */
    public static final int REQ_AWAKE_PASSENGERS = 3;

    /**
     * resposta do servidor
     */
    public static final int AWAKE_PASSENGERS_DONE = 4;

    /**
     * passenger request for number of passengers
     */
    public static final int REQ_N_PASSENGERS_DEPARTURE_TENTRANCE = 5;

    /**
    * resposta do servidor
    */
    public static final int N_PASSENGERS_DEPARTURE_TENTRANCE_DONE = 6;

    /**
     *  passenger request for preparing next flight
     */
    public static final int REQ_PREPARE_NEXT_LEG = 7;

    /**
     * resposta do servidor
     */
    public static final int PREPARE_NEXT_LEG_DONE = 8;
    

    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    /**
     * numero de passengers
     */
    private int nPassenger;
    /**
     * boolean se é ultimo passageiro
     */
    private boolean lastPassenger;
    /**
     * Constructor
     * @param msgType
     */

    public DTEMessage(int msgType){
        this.msgType = msgType;
    }
        /**
     * Constructor
     * @param msgType
     * @param nPassenger
     */

    public DTEMessage(int msgType , int nPassenger){
        this.msgType = msgType;
        this.nPassenger= nPassenger;
    }

     /**
     * Constructor
     * @param msgType
     * @param lastPassenger
     */

    public DTEMessage(int msgType , boolean lastPassenger){
        this.msgType = msgType;
        this.lastPassenger= lastPassenger ;
    }

    public boolean lastPassenger()
    {
        return this.lastPassenger;
    }
    /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }




}   