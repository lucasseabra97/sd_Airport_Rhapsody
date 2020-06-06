package commonInfra;

import java.io.Serializable;
import java.util.ArrayList;
public class BCPMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  porter requests for carrying the bag to the appropriate store (porter requesr)
     */
    public static final int CARRY_IT_TO_APPROPRIATE_STORE = 1;

   /**
    *  porter try to collect a bag (porter request)
    */

    public static final int GO_COLLECT_A_BAG = 2;
    
    /**
     *  Porter alerts that there is no more bags to collect (porter request)
    */

    public static final int NO_MORE_BAGS_TO_COLLECT = 3;
    /**
     * Porter alerts to reset the state of bags (porter request)
    */

    public static final int RESET_STATE= 4;
    
    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 5;

    /**
     *   server recived the message (server response)
     */

    public static final int ACK = 6;


    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    
    /**
     * returns the bag that porter is trying to collect
     */
    private Baggage bag;

    /**
     * list of bags in the baggage collection point
     */

    private ArrayList<Baggage> bagsList;
   
    /**
     * returs the Passenger's ID
     */
    private int passengerID;
   
    /**
     * Constructor
     * @param msgType
     */
     public BCPMessage(int msgType){
        this.msgType = msgType;
     }

    /**
     * Constructor
     * @param msgType
     * @param bag
     */
    public BCPMessage(int msgType, Baggage bag){
        this.msgType = msgType;
        this.bag = bag;
    }
    /**
     * @param msgType
     * @param bagsList
     */
    public BCPMessage(int msgType,  ArrayList<Baggage> bagsList){
        this.msgType = msgType;
        this.bagsList = bagsList;
    }
    /**
     * 
     * @param msgType
     * @param bagsList
     * @param passengerID
     */
    public BCPMessage(int msgType,  ArrayList<Baggage> bagsList , int passengerID){
        this.msgType = msgType;
        this.bagsList = bagsList;
        this.passengerID = passengerID;
    }


    /**
     * getter 
     * @return message Type
     */
    public int getMsgType() {
        return this.msgType;
    }
     /**
     * getter 
     * @return the list of all bags 
     */
    public ArrayList<Baggage> getBaggageList()
    {
        return this.bagsList;
    }

    /**
     * getter 
     * @return baggage
     */
    public Baggage getBaggage(){
        return this.bag;
    }
    
     /**
     * getter 
     * @return passengerID
     */
    public int getPassengerID() {
        return this.passengerID;
    }

    @Override
    public String toString() {
        return "{" +
            " msgType='" + getMsgType() + "'" +
            ", goHome='" + "D" + "'" +
            "}";
    }

}   