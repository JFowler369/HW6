public class Demo {

    public static void main(String[] args) {
        Item i1 = new Item("Energy Drink 10-pack", 546.86, 17.89, 550759400);
        Item i2 = new Item("Ramen 12-pack", 74.84, 17.21, 12);
        Item i3 = new Item("Coke", 454.5, 4.99, 123123123);
        Item i4 = new Item(2.98, 926367);
        CheckoutMachine c = new CheckoutMachine("Walmart");
        try {
            System.out.println("Scanning Item 1: " + i1.toString());
            c.scan(i1);
            System.out.println("Scanning Item 2: " + i2.toString());
            c.scan(i2);
            System.out.println("Scanning Item 3: " + i3.toString());
            c.scan(i3);
            System.out.println("Scanning Item 4: " + i4.toString());
            c.scan(i4);
        } catch(InvalidItemException e) {
            System.out.println(e.toString());
        }
        java.time.LocalDate date = java.time.LocalDate.now();
        date = date.minusMonths(1);
        BuzzCard bCard = new BuzzCard("John Smith", 0.0);
        CreditCard cCard = new CreditCard("John Smith", 1000.0, date);
        Cash cash = new Cash(1000.0);
        boolean payed = false;
        try{
            System.out.println("Trying BuzzCard");
            c.payForCart(bCard);
            payed = true;
        } catch(PaymentFailedException e1) {
            System.out.println(e1.toString());
        }
        if (!payed) {
            try {
                System.out.println("Trying Credit Card");
                c.payForCart(cCard);
                payed = true;
            } catch(PaymentFailedException e2) {
                System.out.println(e2.toString());
            }
        }
        if (!payed) {
            try {
                System.out.println("Paying With Cash");
                c.payForCart(cash);
                payed = true;
            } catch(PaymentFailedException e2) {
                System.out.println(e2.toString());
            }
        }

    }

}
