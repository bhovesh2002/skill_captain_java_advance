package Day9;

public class CustomerThread extends Thread{

    private ShoppingCart cart;

    public CustomerThread(ShoppingCart cart, String name) {
        super(name);
        this.cart = cart;
    }

    public void run() {
        // Add items to cart
        cart.addItem(getName() + " added item 1");
        cart.addItem(getName() + " added item 2");
        cart.addItem(getName() + " added item 3");

        // Remove items from cart
        cart.removeItem(getName() + " added item 1");
        cart.removeItem(getName() + " added item 2");
    }

}
