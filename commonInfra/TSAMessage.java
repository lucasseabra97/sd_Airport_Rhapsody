package commonInfra;

import java.io.Serializable;

public class TSAMessage implements Serializable {
    
  
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  poter requests to carry bags to the appropriate store (porter request)
     */
    public static final int CARRY_IT_TO_APPROPRIATE_STORE = 1;
    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 2;
    /**
    *  server received the message (server response)
    */
    public static final int ACK = 3;

    /* Campos das mensagens */

    /**
     *  Message type
     */

    private int msgType;
    /**
     * returns the bag to carry to the appropriate store
     */
    private Baggage bag;
    /**
     * boolean se é ultimo passageiro
     */
   
    /**
     * Constructor
     * @param msgType
     */

    public TSAMessage(int msgType){
        this.msgType = msgType;

    }
    /**
     * 
     * @param msgType
     * @param bag
     */
    public TSAMessage(int msgType , Baggage bag){
        this.msgType = msgType;
        this.bag = bag;
        
    }
    /**
     * geter bags
     * @return the bag to carry
     */
    public Baggage getBaggage(){
        return this.bag;
    }

    /**
     * getter 
     * @return the message Type
     */
    public int getMsgType() {
        return this.msgType;
    }


}