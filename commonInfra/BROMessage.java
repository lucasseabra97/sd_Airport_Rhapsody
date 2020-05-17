package commonInfra;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
public class BROMessage implements Serializable{
   
   
    /**
     *  Chave de serialização
     */
    private static final long serialVersionUID = 1001L;

    /* Tipos das mensagens */

    /**
     *  Passenger requests ??? (pedido passageiro)
     */
    public static final int REQ_COMPLAIN = 1;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int COMPLAIN_DONE = 2;

    /* Campos das mensagens */

    /**
     *  Tipo da mensagem
     */

    private int msgType;
    

    /**
     * bag memory
     */

    private ArrayList<Baggage> bagsList;
   

    /**
     * Constructor
     * @param msgType
     */

     public BROMessage(int msgType,ArrayList<Baggage> bagsList){
        this.msgType = msgType;
        this.bagsList = bagsList;
     }

     public BROMessage(int msgType){
         this.msgType = msgType;
     }
    /**
     * getter 
     * returns message Type
     */
    public int getMsgType() {
        return this.msgType;
    }

    /**
     * getter
     * returns arraylist of bags
     */
    public ArrayList<Baggage> getBaggageList()
    {
        return this.bagsList;
    }




}   