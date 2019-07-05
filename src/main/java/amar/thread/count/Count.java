package amar.thread.count;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by amarendra on 26/10/17.
 */
public class Count {

    static Map<String, Counter> counterMap = new ConcurrentHashMap();

    static void process() {
        final Set<String> stringSet = counterMap.keySet();
        for (final String str : stringSet) {
            for (int i = 0; i < 50; i++) {
                final Counter counter = counterMap.get(str);
                counter.incrementI();
                //counterMap.put(str,counter);
            }
        }
    }

    public static void main(final String[] args) throws InterruptedException {

        counterMap.put("c1", new Counter(0));

        final ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(Count::process);
        service.submit(Count::process);
        service.submit(Count::process);

        service.awaitTermination(1, TimeUnit.SECONDS);
        service.shutdown();

        System.out.println(counterMap);

    }
}

class Counter {

    private int i = 0;

    public Counter(final int i) {
        this.i = i;
    }

    public int getI() {
        synchronized (Counter.class) {
            return i;
        }
    }

    public void resetI() {
        synchronized (Counter.class) {
            this.i = 0;
        }
    }

    public void incrementI() {
        synchronized (Counter.class) {
            this.i++;
        }
    }

    @Override
    public String toString() {
        return "Counter{" +
                "i=" + i +
                '}';
    }
}
