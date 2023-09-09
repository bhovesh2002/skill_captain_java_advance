package Day9;

public class CustomerThread extends Thread{

    private ShoppingCart cart;

    public CustomerThread(ShoppingCart cart, String name) {
        super(name);
        this.cart = cart;
    }

    public void run() {
        // Add items to cart
        cart.addItem("Noodles");
        cart.addItem("Biscuits");
        cart.addItem("Cold Drink");

        // Remove items from cart
        cart.removeItem("Biscuits");
        cart.removeItem("Cold Drink");
    }

}
