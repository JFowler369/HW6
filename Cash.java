/**
 * Payment Method type
 * @author Jesse Fowler
 * @version 1.0
 */
public class Cash implements PaymentMethod {

    private double cashOnHand;

    /** Creates a cash object with passed balance
      * @param cash Amount of cash to be added
      */
    public Cash(double cash) {
        this.cashOnHand = Math.abs(cash);
    }

    /** Makes payment if sufficiant funds throws exception if not
      * @param amount Amount to be payed
      */
    public void pay(double amount) throws PaymentFailedException {
        try {
            if (amount > this.getBalance()) {
                throw new PaymentFailedException("Not enough cash");
            }
            this.cashOnHand -= amount;
            System.out.println("Transaction Successful");
            System.out.print("Remaining Balance:  ");
            System.out.println(this.getBalance());
        } catch (PaymentFailedException e) {
            throw e;
        }
    }

    /** Returns current amount of cash
      * @return Current amount of cash
      */
    public double getBalance() {
        return this.cashOnHand;
    }

}
