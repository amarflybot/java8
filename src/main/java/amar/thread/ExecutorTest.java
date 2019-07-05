package amar.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by kumarao on 28-01-2016.
 */
public class ExecutorTest {
    private static final int NTHREDS = 10;

    public static void main(String[] args) throws InterruptedException {
        Long startTime = new Date().getTime();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Long>> list = new ArrayList<Future<Long>>();
        for (int i = 0; i < 500; i++) {
            Callable callable = new MyRunnable(1000L + i);
            Future future = executor.submit(callable);
            list.add(future);
        }
        Long sum = 0l;
        System.out.println(list.size());
        // now retrieve the result
        for (Future<Long> future : list) {
            try {
                sum += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total --> " + sum);

        Long endTime = new Date().getTime();
        System.out.println("Total Time Taken --> " + (endTime - startTime));
        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();
        // Wait until all threads are finish
        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Finished all threads");
    }
}
