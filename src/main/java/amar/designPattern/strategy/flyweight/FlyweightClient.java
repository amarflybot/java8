package amar.designPattern.strategy.flyweight;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by amarendra on 04/09/17.
 */
public class FlyweightClient {

    public static void main(String[] args) {

        InventorySystem inventorySystem = new InventorySystem();

        final List<String> list = Arrays.asList("Roomba", "Samsung TV", "Bose Headphones");
        for (int i = 0; i < 100; i++) {
            list
                    .forEach(name -> {
                        inventorySystem.takeOrder(name, ThreadLocalRandom.current().nextInt(100,600));
                    });
        }


        inventorySystem.process();

        System.out.println(inventorySystem.report());

    }
}
