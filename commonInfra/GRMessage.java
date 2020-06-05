package commonInfra;
import java.io.Serializable;
import java.nio.FloatBuffer;

public class GRMessage implements Serializable {

     /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;
    
     /* Tipos das mensagens */

    /**
    * 
    */
    public static final int DRIVER_PARKING_ARRIVAL_TERMINAL = 1;
    /**
    * 
    */
    public static final int DRIVER_PARKING_DEPARTURE_TERMINAL = 2;
    /**
    * 
    */
    public static final int DRIVER_DRIVING_FOWARD = 3;
    /**
    * 
    */
    public static final int DRIVER_DRIVING_BACKWARD = 4;
    /**
    * 
    */
    public static final int PORTER_WAITING_LANDING = 5;
    /**
    * 
    */
    public static final int PORTER_NO_MORE_BAGS = 6;
    /**
    * 
    */
    public static final int PORTER_COLLECT_BAG = 7;
    /**
    * 
    */
    public static final int PORTER_MOVE_BAG_TO_CONVEYOR_BELT = 8;
    /**
    * 
    */
    public static final int PORTER_MOVE_BAG_TO_STOREROOM = 9;
    /**
    * 
    */
    public static final int PASSENGER_INIT = 10;
    /**
    * 
    */
    public static final int PASSENGER_ENTER_LUGGAGE_COLLECTIONPOINT = 11;
    /**
    * 
    */
    public static final int PASSENGER_COLLECT_BAG = 12;
    /**
    * 
    */
    public static final int PASSENGER_COMPLAIN = 13;
    /**
    * 
    */
    public static final int PASSENGER_JOIN_BUS_QUEUE = 14;
    /**
    * 
    */
    public static final int PASSENGER_SIT_IN_BUS = 15;
    /**
    * 
    */
    public static final int PASSENGER_BUS_RIDE = 16;
    /**
    * 
    */
    public static final int PASSENGER_LEAVE_BUS = 17;
    /**
    * 
    */
    public static final int PASSENGER_GO_HOME = 18;
    /**
    * 
    */
    public static final int PASSENGER_PREPARE_NEXT_LEG = 19;
    /**
     * 
     */

    public static final int START_NEXT_FLIGHT = 20;
    /**
    * 
    */
    public static final int ADD_FINAL_DESTINATIONS = 21;
    /**
    * 
    */
    public static final int ADD_TRANSIT = 23;
    /**
    * 
    */
    public static final int ADD_BAG = 24;
    /**
    * 
    */
    public static final int ADD_LOST_BAGS = 25;
    /**
    * 
    */
    public static final int ACK = 26;
    /* Campos das mensagens */

    public static final int SHUTDOWN =27;

    /**
    *  Tipo da mensagem
    */

    private int msgType;
    /**
    * 
    */
    private int id;
    /**
    * 
    */
    private int flightLuggage;
    /**
     * 
     */
    private PassengerEnum state;
    /**
     * 
     */
    private int bags;
    /**
     * 
     */
    private String situation;
    
    /**
     * 
     * @param msgType
     */
    public GRMessage(int msgType){
        this.msgType = msgType;
    }
    public GRMessage(int msgType, int flightLuggage){
      this.flightLuggage = flightLuggage;
    }

    public GRMessage(int msgType,PassengerEnum state, int bags, String situation ,int id){
      this.msgType = msgType;
      this.state = state;
      this.bags = bags;
      this.situation = situation;
      this.id = id;
    }
     /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }

    public int getId() {
      return this.id;
    }

    public PassengerEnum getState() {
      return this.state;
    }

    public int getBags() {
      return this.bags;
    }

    public String getSituation() {
      return this.situation;
    }

    public int getFlightLuggage() {
     return this.flightLuggage;
    }



} 


