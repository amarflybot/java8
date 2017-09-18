package amar.thread;

/**
 * Created by amarendra on 27/01/16.
 */
public class ConsumerProducerTest {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread even = new Thread(new EvenRunner(lock), "EvenThread");
        Thread odd = new Thread(new OddRunner(lock), "OddThread");
        even.start();
        odd.start();
        even.join();
        odd.join();

        System.out.println("All done !!");
    }
}

class EvenRunner implements Runnable {

    private Object lock;

    public EvenRunner(final Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 10; ) {
            synchronized (lock) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " - "+i);
                lock.notify();
                try {
                    lock.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i = i + 2;
        }

    }
}

class OddRunner implements Runnable {

    private Object lock;

    public OddRunner(final Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; ) {
            synchronized (lock) {
                System.out.println("Thread Name: " + Thread.currentThread().getName() + " - "+i);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i = i + 2;
        }
    }
}
