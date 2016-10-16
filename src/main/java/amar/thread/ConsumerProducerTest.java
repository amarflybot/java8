package amar.thread;

/**
 * Created by amarendra on 27/01/16.
 */
public class ConsumerProducerTest {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        RunEven runEven = new RunEven();
        runEven.setLock(lock);
        Thread tEven = new Thread( runEven, "runEven");
        /*Thread tOdd1 = new Thread( runEven);
        Thread tOdd2 = new Thread( runEven);*/

        RunOdd runOdd  = new RunOdd();
        runOdd.setLock(lock);
        Thread tOdd = new Thread( runOdd , "runOdd");
        //RunEven.getAnInt(1);
        //RunOdd.getAnInt(9);
        /*Thread tEven1 = new Thread( runOdd);
        Thread tEven2 = new Thread( runOdd);
*/
        tEven.start();
        //RunEven.getAnInt(4);
        //tEven1.start();
        //tEven2.start();
        //Thread.sleep(1000);
        tOdd.start();
        //RunOdd.getAnInt(5);
        //tOdd1.start();
        //tOdd2.start();
        tEven.join();
        System.out.println("All printing Done !! ");
        tEven.interrupt();
        tOdd.interrupt();
    }
}

class RunOdd implements Runnable{

    private static Object lock;
    private static int iOdd = 1;

    public void setLock(Object lock) {
        RunOdd.lock = lock;
    }

    @Override
    public void run() {
        for (; iOdd <10 ;){
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +" prints "+ iOdd);
                //iOdd = getAnInt(iOdd);
                iOdd = iOdd + 2;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getAnInt(int i) {
        int i1;
        synchronized (lock) {
            i1 = i + 2;
            iOdd = i1;
        }
        return i1;
    }
}

class RunEven implements Runnable{

    private static Object lock;
    private static int iEven = 0;

    public void setLock(Object lock) {
        RunEven.lock = lock;
    }

    @Override
    public void run() {
        for (; iEven <10 ; ){
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +" prints "+ iEven);
                //iEven = getAnInt(iEven);
                iEven= iEven+2;
                lock.notify();
                try {
                    lock.wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getAnInt(int i) {
        int i1;
        synchronized (lock) {
            i1 = i + 2;
            iEven = i1;
        }
        return i1;
    }
}
