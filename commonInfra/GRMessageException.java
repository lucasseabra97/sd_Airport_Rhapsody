package commonInfra;

public class GRMessageException extends Exception{
    /**
   *  Mensagem que originou a excepção
   *    @serialField msg
   */

   private GRMessage msg;

   /**
    *  Instanciação de uma mensagem.
    *
    *    @param errorMessage texto sinalizando a condição de erro
    *    @param msg mensagem que está na origem da excepção
    */
 
    public GRMessageException(String errorMessage, GRMessage msg)
    {
      super (errorMessage);
      this.msg = msg;
    }
 
   /**
    *  Obtenção da mensagem que originou a excepção.
    *
    *    @return mensagem
    */
 
    public GRMessage getMessageVal ()
    {
      return (msg);
    }
}