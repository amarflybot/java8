package amar.thread;

/**
 * Created by amarendra on 09/01/16.
 */
public class MyThread {
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 1; itr < 51; itr = itr + 2) {
                    synchronized (lock) {
                        System.out.println(" Thread1 " + itr);
                        try {
                            lock.notify();
                            lock.wait();
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 2; itr < 51; itr = itr + 2) {
                    synchronized (lock) {
                        System.out.println(" Thread2 " + itr);
                        try {
                            lock.notify();
                            if(itr==50)
                                break;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("\nPrinting over");
        } catch (Exception e) {

        }
    }
}