import java.util.ArrayList;

/**
 * Master program.
 * @author Jesse Fowler
 * @version 1.0
 */
public class CheckoutMachine {

    private String storeName;
    private ArrayList<Item> validItems;
    private ArrayList<Item> cart = new ArrayList();

    /** Creates CheckoutMachine and checks if name is valid and gets
      * valid items
      * @param name Store Name
      */
    public CheckoutMachine(String name) {
        try {
            Server.isStoreNameValid(name);
            this.storeName = name;
        } catch (ServerException e) {
            e.toString();
        }
        try {
            this.validItems = Server.getValidItems();
        } catch (ServerException e) {
            e.toString();
        }
    }

    /** Checks if item is valid and if so adds it to cart
      * @param item Item to scan
      */
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
        } catch (InvalidItemException e) {
            System.out.println(e.toString());
        }
    }

    /** Adds up the total price of all the items in the cart
      * @return The total price of all the items in the cart
      */
    public double getTotalPrice() {
        double total = 0.0;
        for (Item item : cart) {
            total += item.getPrice();
        }
        return total;
    }

    /** Makes payment for items in cart
      * @param method Payment Method
      */
    public void payForCart(PaymentMethod method) throws PaymentFailedException {
        try {
            method.pay(this.getTotalPrice());
        } catch (PaymentFailedException e) {
            //System.out.println(e.toString());
            throw e;
        }
    }

}
