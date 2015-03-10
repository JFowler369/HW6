public class CardExpiredException extends PaymentFailedException {

    public CardExpiredException(String msg) {
        super(msg);
    }

}
