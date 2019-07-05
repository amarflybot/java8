package amar.thread;

/**
 * Created by amarendra on 15/01/16.
 */
// This class exposes a publicly accessible counter
// to help demonstrate data race problem
class Counter {
    public static long count = 0;
}

// This class implements Runnable interface
// Its run method increments the counter three times
class UseCounter implements Runnable {
    private ThreadLocal<Integer> threadLocal =
            new ThreadLocal<Integer>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        System.out.println(threadLocal.get());
    }
}

// This class creates three threads
public class DataRace {

    public static void main(String args[]) throws InterruptedException {
        UseCounter c = new UseCounter();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t1.start();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
}
