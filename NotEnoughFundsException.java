public class NotEnoughFundsException extends PaymentFailedException {

    public NotEnoughFundsException(String msg) {
        super(msg);
    }

}
