/**
 * Exception for Insuffient funds
 * @author Jesse Fowler
 * @version 1.0
 */
public class NotEnoughFundsException extends PaymentFailedException {

    /** Insufficient funds Exception
      * @param msg Exception message
      */
    public NotEnoughFundsException(String msg) {
        super(msg);
    }

}
