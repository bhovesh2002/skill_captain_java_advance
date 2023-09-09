package Day9;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Create a shared shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Create some customer threads
        CustomerThread c1 = new CustomerThread(cart, "Customer 1");
        CustomerThread c2 = new CustomerThread(cart, "Customer 2");
        CustomerThread c3 = new CustomerThread(cart, "Customer 3");

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        // print the cart items
        System.out.println(cart.getItems());
    }

}
