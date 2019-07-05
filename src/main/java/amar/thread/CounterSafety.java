package amar.thread;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by amarendra on 17/09/17.
 */
public class CounterSafety {

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {

            getItRunning();
        }
    }

    public static void getItRunning() throws InterruptedException {
        Runner runner = new Runner();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        runner.finish();
    }
}

class Runner {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int count;

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting");
        condition.await();
        System.out.println("Woken up");
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        System.out.println("Process Return key");
        new Scanner(System.in).nextLine();
        System.out.println("Key Pressed");
        condition.signal();
        try {
            increment();
        } finally {

            lock.unlock();
        }
    }

    public void finish() {
        System.out.println("After all done, count = " + count);
    }
}
