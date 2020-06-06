package commonInfra;
import java.io.Serializable;


public class GRMessage implements Serializable {

     /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;
    
     /* Tipos das mensagens */

    /**
    * driver alerts he has parked in arraival terminal tranfer quay 
    */
    public static final int DRIVER_PARKING_ARRIVAL_TERMINAL = 1;
    /**
    * driver alerts he has parked in departure terminal tranfer quay 
    */
    public static final int DRIVER_PARKING_DEPARTURE_TERMINAL = 2;
    /**
    * bus driver alerts he's driving foward to departure terminal transfer quay 
    */
    public static final int DRIVER_DRIVING_FOWARD = 3;
    /**
    * bus driver alerts he's driving foward to arraival terminal transfer quay 
    */
    public static final int DRIVER_DRIVING_BACKWARD = 4;
    /**
    * porter alerts he's waiting for a plain to land 
    */
    public static final int PORTER_WAITING_LANDING = 5;
    /**
    * porter alerts theres no more bags to collect 
    */
    public static final int PORTER_NO_MORE_BAGS = 6;
    /**
    * porter alerts he's collecting a bag 
    */
    public static final int PORTER_COLLECT_BAG = 7;
    /**
    * porter alerts he's moving the bag to the conveyor belt
    */
    public static final int PORTER_MOVE_BAG_TO_CONVEYOR_BELT = 8;
    /**
    * porter alerts he's moving the bag to the storeroom
    */
    public static final int PORTER_MOVE_BAG_TO_STOREROOM = 9;
    /**
    * initialization of passenger (server al request)
    */
    public static final int PASSENGER_INIT = 10;
    /**
    * passenger alerts he's has entered in the luggage collection point to collect his bag(s)
    */
    public static final int PASSENGER_ENTER_LUGGAGE_COLLECTIONPOINT = 11;
    /**
    * passenger alerts he's collection a bag
    */
    public static final int PASSENGER_COLLECT_BAG = 12;
    /**
    * passenger alerts he's complaining for bag(s) lost
    */
    public static final int PASSENGER_COMPLAIN = 13;
    /**
    * passenger alerts he's in the queue for entering the bus
    */
    public static final int PASSENGER_JOIN_BUS_QUEUE = 14;
    /**
    * passenger alerts he's sit in the bus
    */
    public static final int PASSENGER_SIT_IN_BUS = 15;
    /**
    * passenger alers for bus ride
    */
    public static final int PASSENGER_BUS_RIDE = 16;
    /**
    * passenger alerts he's leaving the bus
    */
    public static final int PASSENGER_LEAVE_BUS = 17;
    /**
    * passenger alerts he's going to home
    */
    public static final int PASSENGER_GO_HOME = 18;
    /**
    * passenger alerts he's prepare to entering in the next leg
    */
    public static final int PASSENGER_PREPARE_NEXT_LEG = 19;
    /**
     * starting next flight
     */
    public static final int START_NEXT_FLIGHT = 20;
    /**
    * final destinations of passengers
    */
    public static final int ADD_FINAL_DESTINATIONS = 21;
    /**
    * passengers in transit
    */
    public static final int ADD_TRANSIT = 23;
    /**
    * adding a bag
    */
    public static final int ADD_BAG = 24;
    /**
    * adding lost bags
    */
    public static final int ADD_LOST_BAGS = 25;
    /**
    * server received the message (server response)
    */
    public static final int ACK = 26;
    /* Campos das mensagens */

    public static final int SHUTDOWN =27;

    /**
    *  Tipo da mensagem
    */

    private int msgType;
    /**
    * return the passengerID
    */
    private int id;
    /**
    * return the number of bags per flight
    */
    private int flightLuggage;
    /**
     * returns the passenger state
     */
    private PassengerEnum state;
    /**
     * return the number of bags per flight
     */
    private int bags;
    /**
     * returns the situation 
     */
    private String situation;
    
    /**
     * 
     * @param msgType
     */
    public GRMessage(int msgType){
        this.msgType = msgType;
    }
    /**
     * 
     * @param msgType
     * @param flightLuggage
     */
    public GRMessage(int msgType, int flightLuggage){
      this.msgType = msgType;
      this.flightLuggage = flightLuggage;
    }
    /**
     * 
     * @param msgType
     * @param state
     * @param bags
     * @param situation
     * @param id
     */
    public GRMessage(int msgType,PassengerEnum state, int bags, String situation ,int id){
      this.msgType = msgType;
      this.state = state;
      this.bags = bags;
      this.situation = situation;
      this.id = id;
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
     * @return the passenger's ID
     */
    public int getId() {
      return this.id;
    }
     /**
     * getter 
     * @return the passenger's state
     */
    public PassengerEnum getState() {
      return this.state;
    }
     /**
     * getter 
     * @return the bags
     */
    public int getBags() {
      return this.bags;
    }
     /**
     * getter 
     * @return the situation
     */
    public String getSituation() {
      return this.situation;
    }
     /**
     * getter 
     * @return number of bags per flight
     */
    public int getFlightLuggage() {
     return this.flightLuggage;
    }



} 


