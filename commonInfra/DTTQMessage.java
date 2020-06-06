package commonInfra;

import java.io.Serializable;

public class DTTQMessage implements Serializable{
    
  
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests for condition wating for ride end (passenger request)
     */
    public static final int WAIT_RIDE = 1;

    /**
     * passenger request to leave the bus passengers (passenger request)
     */
    public static final int LEAVE_THE_BUS = 2;

    /**
     * bus driver request for park the bus and let pass off (busdriver request)
     */
    public static final int PARK_THE_BUS_AND_LET_PASS_OFF = 3;
    
    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 4;
    /**
    *  server recived the message (server response)
    */
    public static final int ACK = 5;
    

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

    public DTTQMessage(int msgType){
        this.msgType = msgType;
    }
    /**
     * Constructor
     * @param msgType
     * @param nPassenger
     */

    public DTTQMessage(int msgType , int nPassenger){
        this.msgType = msgType;
        this.nPassenger= nPassenger;
    }

     /**
     * Constructor
     * @param msgType
     * @param lastPassenger
     */

    public DTTQMessage(int msgType , boolean lastPassenger){
        this.msgType = msgType;
        this.lastPassenger= lastPassenger ;
    }
    /**
     * getter 
     * @return the passenger leaving
     */

    public int getPassengersLeaving()
    {
        return this.nPassenger;
    }


    /**
     * getter 
     * @return message Type
     */
    public int getMsgType() {
        return this.msgType;
    }


}