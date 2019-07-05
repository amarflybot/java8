package amar.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 18/01/16.
 */
public class HashMapTest {

    public static void main(final String[] args) {
        final Map<String, Integer> hm = new HashMap<>();

        final int maxValue = 1 << 30;
        System.out.println(maxValue / 10);
        for (int i = 0; i < (10000000); i++) {
            hm.put(String.valueOf(i), i);
            //System.out.println(i);
        }

        System.out.println("All Done -> " + hm.size());

    }
}

