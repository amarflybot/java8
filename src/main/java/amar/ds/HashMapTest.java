package amar.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by amarendra on 18/01/16.
 */
public class HashMapTest {

    public static void main(String[] args) {
        Map<Element, Integer> hm = new HashMap<>();

        hm.put(new Element(1), 2);
        hm.put(new Element(2), 3);
        hm.put(new Element(3), 4);
        hm.put(new Element(4), 5);
        hm.put(new Element(5), 6);

        Set<Element> elements = hm.keySet();
        int i = 91;
        for(Element element : elements){
            element.setInteger(i++);
        }

        Integer integer = hm.get(new Element(1));
        System.out.println(integer);

    }
}

