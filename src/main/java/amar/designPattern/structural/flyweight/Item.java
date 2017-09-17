package amar.designPattern.structural.flyweight;

/**
 * Created by amarendra on 04/09/17.
 * Instances of @see:Item with be flyweights.
 */
public class Item {

    private final String name;

    public Item(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
