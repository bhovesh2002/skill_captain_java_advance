package Day9;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ShoppingCart cart = new ShoppingCart();

        CustomerThread c1 = new CustomerThread(cart, "c1");
        CustomerThread c2 = new CustomerThread(cart, "c2");
        CustomerThread c3 = new CustomerThread(cart, "c3");

        c1.start();
        c2.start();
        c3.start();

        c1.join();
        c2.join();
        c3.join();

        System.out.println(cart.getItems());
    }

}
