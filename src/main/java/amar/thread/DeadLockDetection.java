package amar.thread;

/**
 * Created by amarendra on 09/01/16.
 */
public class DeadLockDetection {
    static Object lock = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args) {

        DeadlockLoggingBean deadlockLoggingBean = new DeadlockLoggingBean();
        deadlockLoggingBean.init();

        Thread t1 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 1; itr < 51; itr = itr + 2) {
                    synchronized (lock) {
                        System.out.println(" Thread1 " + itr);
                        System.out.println(" Thread1 waiting at acquire lock on lock2");
                        synchronized (lock2) {
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
            }
        }, "Thread1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                for (int itr = 2; itr < 51; itr = itr + 2) {
                    synchronized (lock2) {
                        System.out.println(" Thread2 " + itr);
                        System.out.println(" Thread2 waiting at acquire lock on lock");
                        synchronized (lock) {
                            try {
                                lock.notify();
                                if (itr == 50)
                                    break;
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }, "Thread2");
        try {
            t1.start();
            t2.start();
            t1.join();
            System.out.println("\nPrinting over");
        } catch (Exception e) {

        }
    }
}
