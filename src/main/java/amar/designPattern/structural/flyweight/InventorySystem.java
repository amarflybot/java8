package amar.designPattern.structural.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by amarendra on 04/09/17.
 */
public class InventorySystem {

    private final Catalog catalog = new Catalog();
    private final List<Order> orderList = new CopyOnWriteArrayList<>();

    void takeOrder(final String itemName, final int orderNumber) {
        final Item item = catalog.lookUp(itemName);
        final Order order = new Order(orderNumber, item);
        orderList.add(order);
    }

    void process() {
        orderList.forEach(order -> {
            order.process();
            orderList.remove(order);
        });
    }

    String report() {
        return "\n Total item objects made : " + catalog.totalItemsMade();
    }
}
