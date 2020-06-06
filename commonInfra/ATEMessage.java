package commonInfra;

import java.io.Serializable;

public class ATEMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests for going home and leave the airport (passenger request)
     */
    public static final int GO_HOME = 1;

   /**
    * awake passengers when they can leave the airport
    *  
    */

    public static final int AWAKE_PASSENGERS = 2;
 
    /**
     *  number of passengers un departure terminal entrance 
    */

    public static final int N_PASSENGERS_DEPARTURE_AT = 3;

    /**
     *  Syncronize all passengers that want to leav airport
    */

    public static final int SYNC_PASSENGER= 4;
    /**
     * set parameters for defining the number of passengers in airport
     */
    public static final int SET_PARAM = 5;

    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 6;

    /**
     *  Alert was sent sucessufly (server response)
     */
    public static final int ACK = 7;

    /* Campos das mensagens */

    /**
     *  Type mensagem
     */
    private int msgType;
    /**
    *  returns the passenger's ID
    */
    private int passengerID; 
    /**
     * check either passenger is goingo home or has other fight
    */
    private boolean goHome;
    /**
     * return the number of passenger that want to go home
     */
    private int nPassGoingHome;
    /**
     * Returns all passengers in Arraival Terminal Exit
     */
    
    /**
     * 
     * @param msgType
     * @param goHome
     */
    public ATEMessage(int msgType, int nPass){
        this.msgType = msgType;
        this.nPassGoingHome = nPass;
    }
    /**
     * @param msgType
     * @param nPass
     * @param passengerID
     */
    public ATEMessage(int msgType, int nPass,int passengerID){
        this.msgType = msgType;
        this.nPassGoingHome = nPass;
        this.passengerID  = passengerID;
    }
    /**
     * @param msgType
     * @param goHome
     * @param passengerID
     */
    public ATEMessage(int msgType , boolean goHome,int passengerID){
        this.msgType = msgType;
        this.goHome = goHome;
        this.passengerID = passengerID;
    }
    /**
     * 
     * @param msgType
     * @param goHome
     */
    public ATEMessage(int msgType , boolean goHome){
        this.msgType = msgType;
        this.goHome = goHome;
        
    }
    /**
     * 
     * @param msgType
     */
    public ATEMessage(int msgType){
        this.msgType = msgType;
    }
    /**
     * getter 
     * @return the message type
     */
    public int getMsgType() {
        return this.msgType;
    }
    /**
     * getter
     * @return either passenger is going home or not
     */
    public boolean getGoHome() {
        return this.goHome;
    }
    /**
     * getter
     * @return either passenger is going home or not
     */
    public boolean isGoHome() {
        return this.goHome;
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
     * @return the number of passengers that want to go home
     */
    public int getNPassGoingHome() {
        return this.nPassGoingHome;
    }



    @Override
    public String toString() {
        return "{" +
            " msgType='" + getMsgType() + "'" +
            ", goHome='" + isGoHome() + "'" +
            ", nPassGoingHome='" + getNPassGoingHome() + "'" +
            "}";
    }

}   