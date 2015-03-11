/**
 * Payment Method type
 * @author Jesse Fowler
 * @version 1.0
 */
public class Card implements PaymentMethod {

    private String ownerName;
    private double balance;

    /** Initialization of Card
      * @param name Name of the Card Holder
      * @param balance Balance of Card
      */
    Card(String name, double balance) {
        this.ownerName = name;
        this.balance = balance;
    }

    /** Checks to see if payment is possible. If so it makes payment
      * and prints remaining balance. If not throws exception.
      * @param amount Amount to be payed
      */
    public void pay(double amount) throws PaymentFailedException {
        try {
            if (amount > this.getBalance()) {
                throw new NotEnoughFundsException("Insufficient funds");
            }
            this.balance -= amount;
            System.out.println("Transaction Successful");
            System.out.print("Remaining Balance:  ");
            System.out.println(this.getBalance());
        } catch (PaymentFailedException e) {
            //System.out.println(e.toString());
            throw e;
        }
    }

    /** Returns Card's Balance
      * @return Card's Balance
      */
    public double getBalance() {
        return this.balance;
    }

    /** Checks to see if card has enough funds for payment and throws exception
      * if it doesn't
      * @param amount Amount to be payed
      */
    public void checkFunds(double amount) throws PaymentFailedException {
        if (amount > this.getBalance()) {
            throw new NotEnoughFundsException("Insufficient funds");
        }
    }

}
