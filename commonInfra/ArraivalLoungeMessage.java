package commonInfra;

import java.io.Serializable;
import java.util.List;

public class ArraivalLoungeMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests for what to do when arraives at the airport (pedido passageiro)
     */
    public static final int WHAT_SHOULD_I_DO = 1;

    /**
    * Porter asks for take a rest (porter request)
    */

    public static final int TAKE_A_REST = 2;
    /**
     *  Porter requests to try to collect a bag (porter request)
    */

    public static final int TRY_TO_COLLECCT_A_BAG = 3;
    /**
     *  Passenger alerts Porter to end of day (porter request)
    */
    public static final int END_OF_DAY = 4;
    
    /**
     * set Parameters to Arraival Lounge
     */

     public static final int SET_PARAMETERS = 5;
    
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
     *  Tipo da mensagem
     */
    private int msgType;
    
    /**
    *  verifica se o passageiro vai para casa ou tempo outro voo 
    */   
    private boolean goHome;
    /**
     * returns the number of passengers -> whatshouldIDo
    */
    private int nPass;
    /**
     *  returns the bag to collect
     */
    private Baggage bag;
    /**
     *  return the nº of bags 
     */
    private int bags ;
    /**
     *  returns Passenger's ID
     */
    private int passengerID;
    /**
     * return condition if porter need to wait
     */
    private boolean takeRest;
    /**
     * return the list of bags per flights
     */
    private List<List<Baggage>> bagsPerFlight;
    /**
     * 
     * @param msgType
     * @param goHome
     */
    public ArraivalLoungeMessage(int msgType,int nrPassengers,  List<List<Baggage>> bagsPerFlight){
        this.msgType = msgType;
        this.nPass = nrPassengers;
        this.bagsPerFlight = bagsPerFlight;
        
    }
     /**
     * 
     * @param msgType
     * @param goHome
     */
    public ArraivalLoungeMessage(int msgType,boolean goHome , int bags , int passengerID){
        this.msgType = msgType;
        this.goHome = goHome;
        this.bags = bags;
        this.passengerID = passengerID;
    }   

      /**
     * 
     * @param msgType
     * @param goHome
     */
    public ArraivalLoungeMessage(int msgType,Baggage bag){
        this.msgType = msgType;
        this.bag = bag;
        
    } 

    /**
     * 
     * @param msgType
     */
    public ArraivalLoungeMessage(int msgType){
        this.msgType = msgType;
    }
    
    /**
     * getter 
     * @return the list of bags per flight
     */
    public List<List<Baggage>> getBagsList(){
        return this.bagsPerFlight;
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
     * @return either is going home or not(boolean)
     */
    public boolean getGoHome() {
        return this.goHome;
    }
     /**
     * getter 
     * @return either is going home or not(boolean)
     */
    public boolean isGoHome() {
        return this.goHome;
    }
     /**
     * getter 
     * @return the bag that porter will collect
     */
    public Baggage tryToCollectABag(){
        return this.bag;
    }
    /**
     * 
     * @param msgType
     * @param nPass
     */
    public ArraivalLoungeMessage(int msgType,int nPass){
        this.msgType = msgType ;
        this.nPass   = nPass;
    }       
     /**
     * getter 
     * @return either porter is taking a rest or not(boolean)
     */
    public boolean getTakeRest() {
        return this.takeRest;
    }
    /**
     * getter 
     * @return either porter is taking a rest or not(boolean)
     */
    public boolean isTakeRest() {
        return this.takeRest;
    }
    /**
     * getter 
     * @return the baggage
     */
    public Baggage getBag() {
        return this.bag;
    }
    /**
     * getter 
     * @return the number of passengers
     */
    public int getNPass() {
        return this.nPass;
    }
    /**
     * getter 
     * @return the number of bags
     */
    public int getBagsNumber(){
        return this.bags;
    }
    /**
     * getter 
     * @return the passengerID
     */
    public int getPassengerID() {
		return this.passengerID;
	}


    @Override
    public String toString() {
        return "{" +
            " msgType='" + getMsgType() + "'" +
            ", goHome='" + isGoHome() + "'" +
            ", nPass='" + getNPass() + "'" +
            ", bag='" + getBag() + "'" +
            ", takeRest='" + isTakeRest() + "'" +
            "}";
    }


	

}   