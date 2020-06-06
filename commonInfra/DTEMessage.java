package commonInfra;

import java.io.Serializable;
public class DTEMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Syncronize all passengers that want to leav airport (passenger requst)
     */
    public static final int SYNC_PASSENGER = 1;

    /**
     * passenger request to awake passengers that want to leave the airport (passenger request)
     */
    public static final int AWAKE_PASSENGERS = 2;
    /**
     * passenger request for number of passengers in the departure terminal entrance (passenger request)
     */
    public static final int N_PASSENGERS_DEPARTURE_TENTRANCE = 3;
    /**
     *  passenger request for preparing next flight (passenger request)
     */
    public static final int PREPARE_NEXT_LEG = 4;
    /**
     *  set parameters to know the number of passenger per flight
     */
    public static final int SET_PARAM = 5;
    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 6;
    /**
     * server recived the message (server response)
     */
    public static final int ACK = 7;
    

    /* Campos das mensagens */

    /**
     * passenger ID
     */
    private int passengerID;
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
    public DTEMessage(int msgType , int nPassenger , int passengerID){
        this.msgType = msgType;
        this.nPassenger= nPassenger;
        this.passengerID = passengerID;
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
    /**
     * 
     * @param msgType
     * @param nPassenger
     */
    public DTEMessage(int msgType,int nPassenger){
        this.msgType = msgType;
        this.nPassenger= nPassenger;
    }
    /**
     * getter
     * @return either is the last passenger or not
     */
    public boolean lastPassenger()
    {
        return this.lastPassenger;
    }
    /**
     * getter
     * @return the number of passengers in departure terminal entrance
     */
    public int nPassenger()
    {
        return this.nPassenger;
    }
    /**
     * getter
     * @return passengerID
     */
    public int getPassengerID(){
        return this.passengerID;
    }
    /**
     * getter 
     * @return message Type
     */
    public int getMsgType() {
        return this.msgType;
    }




}   