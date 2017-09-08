package amar.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by amarendra on 06/09/17.
 */
public class CountDownThreadTest {

    private static int MAX_THREAD = 5;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(MAX_THREAD);

        for (int i = 0; i < MAX_THREAD; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("Running !");
                    latch.countDown();
                }
            });
            thread.start();
        }
        System.out.println("Spawning Finished");
        System.out.println("Waiting All Threads to Finish");
        latch.await();
        System.out.println("All Over!");

    }
}
