package amar.thread;

/**
 * Created by amarendra on 15/01/16.
 */
// This class exposes a publicly accessible counter
// to help demonstrate data race problem
class Counter {
    public static long count=0;
}
// This class implements Runnable interface
// Its run method increments the counter three times
class UseCounter implements Runnable {
    Object object = new Object();
    public void increment() {
        // increments the counter and prints the value
        // of the counter shared between threads
        synchronized (object) {
            Counter.count++;
            System.out.println(Thread.currentThread().getName() +" "+ Counter.count + "  ");
        }
    }
    public void run() {
        increment();
        increment();
        increment();
    } }
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