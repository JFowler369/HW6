/**
 * Payment Method type
 * @author Jesse Fowler
 * @version 1.0
 */
public class CreditCard extends Card {

    private java.time.LocalDate expirationDate;

    /** Creates Credit Card with given name, balance, and expiration date
      * @param name Name of card holder
      * @param balance Balance on card
      * @param date Expiration date of card
      */
    public CreditCard(String name, double balance, java.time.LocalDate date) {
        super(name, balance);
        this.expirationDate = date;
    }

    /** Makes payment on cart
      * @param amount amount to be paid
      */
    @Override
    public void pay(double amount) throws PaymentFailedException {
        try {
            this.checkExpirationDate();
            super.pay(amount);
        } catch (PaymentFailedException e) {
            throw e;
        }
    }

    /** Checks expiration date of card
      */
    public void checkExpirationDate() throws PaymentFailedException {
        if (this.getExpirationDate().isBefore(this.getExpirationDate().now())) {
            throw new CardExpiredException("Card Expired");
        }
    }

    /** Returns the card expiration date
      * @return the Card's expiration date
      */
    public java.time.LocalDate getExpirationDate() {
        return this.expirationDate;
    }

}
