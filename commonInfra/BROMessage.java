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
    public static final int COMPLAIN = 1;
    /**
     * 
     */
    public static final int SET_PARAM = 2;

    /**
     *  request for shutdown server
     */
    public static final int SHUTDOWN = 3;

    /**
    *   (resposta enviada pelo servidor)
    */
    public static final int ACK = 4;

	/**
     * passenger ID
     */
    private int passengerID;
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

     public BROMessage(int msgType,ArrayList<Baggage> bagsList , int passengerID){
        this.msgType = msgType;
        this.bagsList = bagsList;
        this.passengerID = passengerID;
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

    public int getPassengerID(){
        return this.passengerID;
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