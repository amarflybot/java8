package amar.thread;

/**
 * Created by amarendra on 27/01/16.
 */
public class ConsumerProducerTest {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        RunEven runEven = new RunEven();
        runEven.setLock(lock);
        Thread tOdd = new Thread( runEven, "runEven");
        /*Thread tOdd1 = new Thread( runEven);
        Thread tOdd2 = new Thread( runEven);*/

        RunOdd runOdd  = new RunOdd();
        runOdd.setLock(lock);
        Thread tEven = new Thread( runOdd , "runOdd");
        /*Thread tEven1 = new Thread( runOdd);
        Thread tEven2 = new Thread( runOdd);
*/
        tEven.start();
        //tEven1.start();
        //tEven2.start();
        Thread.sleep(1000);
        tOdd.start();
        //tOdd1.start();
        //tOdd2.start();
        tEven.join();
        System.out.println("All printing Done !! ");

    }
}

class RunOdd implements Runnable{

    private Object lock;

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 1; i<10 ;){
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +" prints "+ i);
                i = i+2;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RunEven implements Runnable{

    private Object lock;

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i<10 ; ){
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() +" prints "+ i);
                i = i+2;
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
