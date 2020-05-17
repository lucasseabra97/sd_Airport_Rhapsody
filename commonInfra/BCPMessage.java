package commonInfra;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class BCPMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests ??? (pedido passageiro)
     */
    public static final int REQ_CARRY_IT_TO_APPROPRIATE_STORE = 1;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int CARRY_IT_TO_APPROPRIATE_STORE_DONE = 2;

   /**
    *  pedido invocado  cliente na saida 
    */

    public static final int REQ_GO_COLLECT_A_BAG = 3;
    /** 
     *   (resposta enviada pelo servidor)
     */

    public static final int GO_COLLECT_A_BAG_DONE = 4;
    /**
     *   (pedido do porteiro)
    */

    public static final int REQ_NO_MORE_BAGS_TO_COLLECT = 5;
    /**
     *   (resposta enviada pelo servidor)
     */

    public static final int NO_MORE_BAGS_TO_COLLECT_DONE = 6;
    /**
     *  (pedido do passageiro)
    */

    public static final int REQ_RESET_STATE= 7;
    /**
     *   (resposta do servidor)
     */

    public static final int RESET_STATE_DONE = 8;


    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    
    /**
     * baggage para goCOllectABag
     */
    private Baggage bag;

    /**
     * bag memory
     */

    private ArrayList<Baggage> bagsList;
   

    /**
     * Constructor
     * @param msgType
     */

     public BCPMessage(int msgType){
        this.msgType = msgType;
     }

    /**
     * Constructor
     * @param msgType
     * @param bag
     */
    public BCPMessage(int msgType, Baggage bag){
        this.msgType = msgType;
        this.bag = bag;
    }


    public BCPMessage(int msgType,  ArrayList<Baggage> bagList){
        this.msgType = msgType;
        this.bagsList = bagsList;
    }

    /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }

    public ArrayList<Baggage> getBaggageList()
    {
        return this.bagsList;
    }


    /**
     * getter 
     * returns baggage
     */
    public Baggage getBaggage(){
        return this.bag;
    }
 

    @Override
    public String toString() {
        return "{" +
            " msgType='" + getMsgType() + "'" +
            ", goHome='" + "D" + "'" +
            "}";
    }

}   