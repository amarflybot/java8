package amar.designPattern.structural.flyweight;

/**
 * Created by amarendra on 04/09/17.
 */
public class Order {

    private final int orderNumber;
    private final Item item;

    public Order(final int orderNumber, final Item item) {
        this.orderNumber = orderNumber;
        this.item = item;
    }

    void process(){
        System.out.println("Ordering " + item+ " for order number " + orderNumber);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", item=" + item +
                '}';
    }
}
