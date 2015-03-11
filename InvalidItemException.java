public class InvalidItemException extends Exception {

    private String msg;

    public InvalidItemException(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return this.msg;
    }

}
