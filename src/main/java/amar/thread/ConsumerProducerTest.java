package amar.thread;

/**
 * Created by amarendra on 27/01/16.
 */
public class ConsumerProducerTest {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        Thread tOdd = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i<10 ; i = i+2){
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() +" prints "+ i);

                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "TODD");

        Thread tEven = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10 ; i = i+2){
                    synchronized (lock) {
                        System.out.println(Thread.currentThread().getName() +" prints "+ i);

                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "TEVEN");
        tEven.start();
        Thread.sleep(1000);
        tOdd.start();
        tEven.join();
        System.out.println("All printing Done !! ");
        tEven.stop();
        tOdd.stop();
    }
}
