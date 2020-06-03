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
    public static final int SYNC_PASSENGER = 1;


    /**
     * passenger request to awake passengers 
     */
    public static final int AWAKE_PASSENGERS = 2;

    /**
     * passenger request for number of passengers
     */
    public static final int N_PASSENGERS_DEPARTURE_TENTRANCE = 3;

   
    /**
     *  passenger request for preparing next flight
     */
    public static final int PREPARE_NEXT_LEG = 4;

    /**
     *  
     */
    public static final int SET_PARAM = 5;
    /**
     * resposta do servidor
     */
    public static final int ACK = 6;
    

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

    public int nPassenger()
    {
        return this.nPassenger;
    }
    /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }




}   