package amar.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * Created by amarendra on 28/07/16.
 */
public class ExecutorStringTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName());
                    }
                });
                return thread;
            }
        });

        List<Future<String>> futureList = new ArrayList<>();

        Callable<String> stringCallable = new StringRunnable();

        for (int i = 0; i < 100; i++) {
            futureList.add(executor.submit(stringCallable));
        }
        int i = 0;
        for (Future<String> future : futureList) {
            try {
                if (future.isDone()) {
                    System.out.println("Date " + new Date() + " Thread Name - " + future.get() + " Count = " + i++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
