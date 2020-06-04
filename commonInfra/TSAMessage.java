package commonInfra;

import java.io.Serializable;

public class TSAMessage implements Serializable {
    
  
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  poter requests to carry bags 
     */
    public static final int CARRY_IT_TO_APPROPRIATE_STORE = 1;
    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 2;
    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int ACK = 3;

    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    /**
     * numero de passengers
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
    
    public TSAMessage(int msgType , Baggage bag){
        this.msgType = msgType;
        this.bag = bag;
        
    }
    /**
     * geter bags
     * @return bag
     */
    public Baggage getBaggage(){
        return this.bag;
    }

    /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }


}