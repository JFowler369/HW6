/**
 * Exception for when card is expired
 * @author Jesse Fowler
 * @version 1.0
 */
public class CardExpiredException extends PaymentFailedException {

    /** Creates a PaymentFailedException when a card is expired
      * @param msg Reason for exception
      */
    public CardExpiredException(String msg) {
        super(msg);
    }

}
