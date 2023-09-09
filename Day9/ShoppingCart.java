package Day9;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShoppingCart {

    private CopyOnWriteArrayList<String> items;

    //constructor
    public ShoppingCart() {
        items = new CopyOnWriteArrayList<String>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public CopyOnWriteArrayList<String> getItems() {
        return items;
    }
}
