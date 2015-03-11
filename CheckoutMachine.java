import java.util.ArrayList;

public class CheckoutMachine {

    private String storeName;
    private ArrayList<Item> validItems;
    private ArrayList<Item> cart = new ArrayList();

    public CheckoutMachine(String name) {
        try {
            Server.isStoreNameValid(name);
            this.storeName = name;
        } catch(ServerException e) {
            e.toString();
        }
        try {
            this.validItems = Server.getValidItems();
        } catch(ServerException e) {
            e.toString();
        }
    }

    public void scan(Item item) throws InvalidItemException {
        boolean valid = false;
        try {
            for (Item items : validItems) {
                if (item.equals(items)) {
                    cart.add(items);
                    valid = true;
                }
            }
            if (!valid) {
                throw new InvalidItemException("Invalid Item");
            }
        } catch(InvalidItemException e) {
            System.out.println(e.toString());
        }
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Item item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    public void payForCart(PaymentMethod method) throws PaymentFailedException {
        try {
            method.pay(this.getTotalPrice());
        } catch(PaymentFailedException e) {
            //System.out.println(e.toString());
            throw e;
        }
    }

}
