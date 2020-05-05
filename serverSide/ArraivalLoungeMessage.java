package serverSide;

import java.io.Serializable;

public class ArraivalLoungeMessage implements Serializable{
   
   
   /**
   *  Chave de serialização
   */
   private static final long serialVersionUID = 1001L;

   /* Tipos das mensagens */

   /**
   *  Inicialização do ficheiro de logging (operação pedida pelo cliente)
   */
   public static final int SETNFIC  =  1;

   /**
   *  Ficheiro de logging foi inicializado (resposta enviada pelo servidor)
   */
   public static final int NFICDONE =  2;

  /**
   *  Passenger requests for what to do when arraives at the airport (pedido passageiro)
   */
   public static final int WHAT_SHOULD_I_DO = 3;

   /**
    * Porter asks for take a rest (pedido do cliente)
    */
    public static final int TAKE_A_REST = 4;

    /**
     *  Porter ...
    */
    public static final int TRY_TO_COLLECCT_A_BAG = 5;

    /**
     *  Passenger alerts Porter to end of day 
    */
    public static final int END_OF_DAY = 6;
}   