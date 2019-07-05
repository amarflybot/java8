package amar.thread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by amarendra on 15/01/16.
 */
public class ProdCons {

    private static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(10);

    public static void main(final String[] args) throws InterruptedException {

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producer();
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }

    private static void producer() throws InterruptedException {
        final Random random = new Random(100);
        while (true) {
            blockingQueue.put(random.nextInt(10));
        }
    }

    private static void consumer() throws InterruptedException {
        final Random random = new Random(10);
        while (true) {
            Thread.sleep(100);
            if (random.nextInt(10) == 0) {
                final Integer taken = blockingQueue.take();
                System.out.println("Taken out " + taken + " Queue Size " + blockingQueue.size());
            }
        }
    }
}
