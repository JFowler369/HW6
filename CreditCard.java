public class CreditCard extends Card {

    private java.time.LocalDate expirationDate;

    public CreditCard(String name, double balance, java.time.LocalDate date) {
        super(name, balance);
        this.expirationDate = date;
    }

    @Override
    public void pay(double amount) throws PaymentFailedException {
        try {
            this.checkExpirationDate();
            super.pay(amount);
        } catch (PaymentFailedException e) {
            throw e;
        }
    }

    public void checkExpirationDate() throws PaymentFailedException {
        if (this.getExpirationDate().isBefore(this.getExpirationDate().now())) {
            throw new CardExpiredException("Card Expired");
        }
    }

    public java.time.LocalDate getExpirationDate() {
        return this.expirationDate;
    }

}
