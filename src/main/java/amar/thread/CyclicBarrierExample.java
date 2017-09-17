package amar.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by amarendra on 15/09/17.
 */
public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {

        CounterSync counterSync = new CounterSync();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(500, new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Waiting for 5 secs..");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Since all threads are good not, Let's start");
            }
        });

        for (int i = 0; i < 500; i++) {


            Thread t1 = new Thread(new CyclicWorker(cyclicBarrier, counterSync));
            t1.start();

        }
        System.out.println("counterSync.getI() -> "+ counterSync.getI());
        System.out.println("CyclicBarrierExample ending!!");
    }

}

class CyclicWorker implements Runnable {

    CyclicBarrier cyclicBarrier;
    CounterSync counterSync;
    public CyclicWorker(final CyclicBarrier cyclicBarrier, final CounterSync counterSync) {
        this.cyclicBarrier = cyclicBarrier;
        this.counterSync = counterSync;
    }

    @Override
    public void run() {
        final String threadName = Thread.currentThread().getName();
        System.out.println("Entered CyclicWorker by Thread-Name: "+ threadName);
        try {
            System.out.println(" cyclic Barrier.get Number Waiting "+ cyclicBarrier.getNumberWaiting());
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        counterSync.incrementI();
        System.out.println("Getting value of counterSync " + counterSync.getI() + " for thread " + threadName);
        System.out.println("Leaving CyclicWorker by Thread-Name: "+ threadName);
    }
}

class CounterSync{

    private int i;

    public int getI() {
        return i;
    }

    public void reSetI() {
        this.i=0;
    }

    public void incrementI(){
        ++this.i;
    }
}
