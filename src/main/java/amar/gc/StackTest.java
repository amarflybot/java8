package amar.gc;

import java.util.HashMap;
import java.util.Map;

/**
 * This system shall create OutOfMemoryError after some time.
 * Created by kumarao on 18-01-2016.
 */
public class StackTest {

    public static void main(final String[] args) {
        final Map m = new HashMap();
        while (true)
            for (int i = 0; i < 10000; i++)
                if (!m.containsKey(new KeylessEntry.Key(i)))
                    m.put(new KeylessEntry.Key(i), "Number:" + i);

    }
}
