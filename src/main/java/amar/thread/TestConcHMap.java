package amar.thread;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by amarendra on 26/10/17.
 */
public class TestConcHMap {

    static Map<String, AtomicInteger> map = new ConcurrentHashMap<>();

    static void process() {
        final Set<String> stringSet = map.keySet();

        for (String city : stringSet) {
            for (int i = 0; i < 50; i++) {
                map.get(city).getAndIncrement();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        map.put("Bombay",new AtomicInteger(0));
        map.put("Delhi",new AtomicInteger(0));
        map.put("Jamshedpur",new AtomicInteger(0));
        map.put("Bangalore",new AtomicInteger(0));

        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(TestConcHMap::process);
        executorService.submit(TestConcHMap::process);

        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();

        System.out.println(map);
    }

}
