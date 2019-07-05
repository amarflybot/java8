package amar.algorithm.general;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendrakumar on 02/06/17.
 */
public class Test {

    public static void main(final String[] args) throws IOException {

        final Map<Integer, String> map = new HashMap<>();

        for (int i = 0; i < 13; i++) {
            map.put(i, String.valueOf(i));
        }

        final String s = map.get(3);
        System.out.println(s);
    }
}


