package commonInfra;

import java.io.Serializable;
import java.util.ArrayList;
public class BROMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  The client complains of lost bags (passenger request)
     */
    public static final int COMPLAIN = 1;
    /**
     * Set parameters 
     */
    public static final int SET_PARAM = 2;

    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 3;

    /**
    *  server recived the message (server response)
    */
    public static final int ACK = 4;

	
    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */
    private int msgType;
    /**
     * return the passenger's ID
     */
    private int passengerID;

    /**
     * returns the list of bags lost
    */
    private ArrayList<Baggage> bagsList;
   
    /**
     * 
     * @param msgType
     * @param bagsList
     * @param passengerID
     */
     public BROMessage(int msgType,ArrayList<Baggage> bagsList , int passengerID){
        this.msgType = msgType;
        this.bagsList = bagsList;
        this.passengerID = passengerID;
     }
     /**
      * 
      * @param msgType
      */
     public BROMessage(int msgType){
         this.msgType = msgType;
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
     * @return the passenger ID
     */
    public int getPassengerID(){
        return this.passengerID;
    }
    /**
     * getter
     * @return the list of bags lost
     */
    public ArrayList<Baggage> getBaggageList()
    {
        return this.bagsList;
    }


    @Override
    public String toString() {
        return "{" +
            " msgType='" + msgType + "'" +
            ", passengerID='" + passengerID + "'" +
            ", bagsList='" + bagsList + "'" +
            "}";
    }


}   