package amar.designPattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 04/09/17.
 */
public class Catalog {

    private Map<String, Item> itemMap = new HashMap<>();

    public Item lookUp(String itemName){
        if (!itemMap.containsKey(itemName)) {
            itemMap.put(itemName, new Item(itemName));
        }
        return itemMap.get(itemName);
    }

    public int totalItemsMade(){
        return itemMap.size();
    }

}
