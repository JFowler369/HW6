public class Card implements PaymentMethod {

    private String ownerName;
    private double balance;

    Card(String name, double balance) {
        this.ownerName = name;
        this.balance = balance;
    }

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

    public double getBalance() {
        return this.balance;
    }

    public void checkFunds(double amount) throws PaymentFailedException {
        if (amount > this.getBalance()) {
            throw new NotEnoughFundsException("Insufficient funds");
        }
    }

}
