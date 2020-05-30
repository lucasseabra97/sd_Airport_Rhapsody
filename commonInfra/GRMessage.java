package commonInfra;
import java.io.Serializable;

public class GRMessage implements Serializable {

     /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;
    
     /* Tipos das mensagens */

     /**
      * add flight
      */
    public static final int ADD_FLIGHT = 1 ;

    /**
     * return flights 
     */
    public static final int GET_FLIGHT = 2;

    /**
     * sets the flight luggage 
     */
    public static final int SET_FLIGHT_LUGGAGE = 3;

    /**
     * state of passenger
     */

    public static final int PASSENGER_STATE = 4 ;
    
     /**
     * state of porter
     */

    public static final int PORTER_STATE = 5 ;

     /**
      * state of bus driver
      */
    public static final int BUS_DRIVER_STATE = 6;
    
    /**
     * sets the driver state
     */
    public static final int DRIVER_PARKING_ARRIVAL_TERMINAL = 7;
    


    





} 


