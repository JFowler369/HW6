/**
 * Exception for Invalid Items
 * @author Jesse Fowler
 * @version 1.0
 */
public class InvalidItemException extends Exception {

    private String msg;

    /** Invalid Item exception.
      * @param msg Exception message
      */
    public InvalidItemException(String msg) {
        this.msg = msg;
    }

    /** Returns exception message
      * @return exception message
      */
    public String toString() {
        return this.msg;
    }

}
