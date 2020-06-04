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
    * Porter asks for take a rest (pedido do porteiro)
    */

    public static final int TAKE_A_REST = 2;
    /**
     *  Porter requests to try to collect a bag (pedido do porteiro)
    */

    public static final int TRY_TO_COLLECCT_A_BAG = 3;
    /**
     *  Passenger alerts Porter to end of day (pedido do passageiro)
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
     *  Alert was sent sucessufly (resposta do servidor)
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
     * retorna o numero de passageiros -> whatshouldIDo
     */
    private int nPass;

    private Baggage bag;



    
    /**
     * retorna condição de espera para o porter
     */
    private boolean takeRest;

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
    public ArraivalLoungeMessage(int msgType,boolean goHome){
        this.msgType = msgType;
        this.goHome = goHome;
        
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


    public ArraivalLoungeMessage(int msgType){
        this.msgType = msgType;
    }


    public List<List<Baggage>> getBagsList(){
        return this.bagsPerFlight;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public boolean getGoHome() {
        return this.goHome;
    }

    public boolean isGoHome() {
        return this.goHome;
    }

    public Baggage tryToCollectABag(){
        return this.bag;
    }
    public ArraivalLoungeMessage(int msgType,int nPass){
        this.msgType = msgType ;
        this.nPass   = nPass;
    }     

    public boolean getTakeRest() {
        return this.takeRest;
    }

    public boolean isTakeRest() {
        return this.takeRest;
    }

    public Baggage getBag() {
        return this.bag;
    }
    
    public int getNPass() {
        return this.nPass;
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