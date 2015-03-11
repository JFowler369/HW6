public class Cash implements PaymentMethod {

    private double cashOnHand;

    public Cash(double cash) {
        this.cashOnHand = Math.abs(cash);
    }

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

    public double getBalance() {
        return this.cashOnHand;
    }

}
