public class PaymentFailedException extends Exception {

    private String msg;

    public PaymentFailedException(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return this.msg;
    }

}
