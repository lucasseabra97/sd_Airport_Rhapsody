package commonInfra;

import java.io.Serializable;

public class ATTQMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  
     */
    public static final int DEPARTURE_TIME = 1;

   /**
    * passenger requests for taking the bus (passenger request)
    */

    public static final int TAKE_A_BUS = 2;
   
    /**
     *  passenger requests for entering the bus after the approval of the busdriver (passenger request)
    */

    public static final int ENTER_THE_BUS = 3;
    /**
     *  bus driver requests if his day has ended (busDriver request)
    */

    public static final int HAS_DAYS_WORK_ENDED= 4;

    /**
     * bus driver request for announcing the bus boarding and so he can leave the area (busdriver request)
     */
    public static final int ANNOUNCING_BUS_BOARDING= 5;
    /**
    *  passenger request to end of day the busdriver lifecycle (passenger request)
    */   
    public static final int END_OF_DAY = 6;
    /**
    *  set parameters so that we are able to know the max capacity of the bus
    */ 
    public static final int SET_PARAM = 7;
    /**
     *  request to shutdown server
     */
    public static final int SHUTDOWN = 8;

    /**
     *  Alert was sent sucessufly (server response)
     */
    public static final int ACK = 9;


  
    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    /**
     * returs the number of passengers inside the bus
     */
    private int insidePass;
    /**
     * returns the bus capacity
     */
    private int busSize;
    /**
     * returns the action that busdriver will execute
     */
    private BusDriverAction busDAction;

    /**
     * Constructor 
     * @param msgType
     * @param busDAction
     */
    public ATTQMessage(int msgType, BusDriverAction busDAction){
        this.msgType = msgType;
        this.busDAction = busDAction;
    }

    /**
     * 
     * @param msgType
     * @param insidePass
     */
    public ATTQMessage(int msgType , int insidePass){
        this.msgType = msgType;
        if(msgType==SET_PARAM){
            this.busSize = insidePass;
        }
        else{
            this.insidePass = insidePass;
        }
        
        
    }
    /**
     * 
     * @param msgType
     */
    public ATTQMessage(int msgType){
        this.msgType = msgType;
    }

    /**
     * getter
     * @return the capacity of the bus
     */
    public int getBusSize() {
        return this.busSize;
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
     * @return the number of passengers inside the bus
     */
    public int getInsidePassengers() {
        return this.insidePass;
    }   
    /**
     * getter
     * @return the action busdriver will execute next
     */
    public BusDriverAction getBusDAction() {
        return this.busDAction;
    }
    
    

    @Override
    public String toString() {
        return "{" +
            " msgType='" + msgType + "'" +
            ", insidePass='" + insidePass + "'" +
            ", busDAction='" + busDAction + "'" +
            "}";
    }
    


}   