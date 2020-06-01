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
    public static final int CARRY_IT_TO_APPROPRIATE_STORE = 1;

   /**
    *  pedido invocado  cliente na saida 
    */

    public static final int GO_COLLECT_A_BAG = 2;
    
    /**
     *   (pedido do porteiro)
    */

    public static final int NO_MORE_BAGS_TO_COLLECT = 3;
    /**
     *  (pedido do passageiro)
    */

    public static final int RESET_STATE= 4;
    /**
     *   (resposta do servidor)
     */

    public static final int ACK = 5;


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


    public BCPMessage(int msgType,  ArrayList<Baggage> bagsList){
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