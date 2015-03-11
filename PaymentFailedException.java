/**
 * Payment Method exception
 * @author Jesse Fowler
 * @version 1.0
 */
public class PaymentFailedException extends Exception {

    private String msg;

    /** Payment Method Failed exception.
      * @param msg Exception message
      */
    public PaymentFailedException(String msg) {
        this.msg = msg;
    }

    /** Returns exception message
      * @return exception message
      */
    public String toString() {
        return this.msg;
    }

}
