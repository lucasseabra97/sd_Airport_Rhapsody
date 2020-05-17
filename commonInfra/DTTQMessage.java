package commonInfra;

import java.io.Serializable;

public class DTTQMessage implements Serializable{
    
  
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests for condition wating for ride end
     */
    public static final int REQ_WAIT_RIDE = 1;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int WAIT_RIDE_DONE = 2;

    /**
     * passenger request to leave the bus passengers 
     */
    public static final int REQ_LEAVE_THE_BUS = 3;

    /**
     * resposta do servidor
     */
    public static final int LEAVE_THE_BUS_DONE = 4;

    /**
     * bus driver request for park the bus and let pass off
     */
    public static final int REQ_PARK_THE_BUS_AND_LET_PASS_OFF = 5;

    /**
    * resposta do servidor
    */
    public static final int PARK_THE_BUS_AND_LET_PASS_OFF_DONE = 6;
    

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


    public int getPassengersLeaving()
    {
        return this.nPassenger;
    }
    /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }


}