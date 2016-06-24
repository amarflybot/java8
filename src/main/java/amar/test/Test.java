package amar.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by amarendra on 22/04/16.
 */
public class Test {

    public static void main(String[] args) {

        /*Object lock = new Object();
        Odd odd = new Odd();
        odd.setLock(lock);
        Even even = new Even();
        even.setLock(lock);

        Thread threadEven = new Thread(even);
        Thread threadOdd = new Thread(odd);

        threadEven.start();
        threadOdd.start();*/
        String str = new String ("A");
        String str1 = "A";
        str.intern();

        System.out.println(str.equals(str1));
        System.out.println(str == str1);

    }
}

class Odd implements Runnable {

    private Object lock;

    public void setLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        for (int i = 1; i < 11; i = i + 2) {
            synchronized (lock) {
                System.out.println(i + " "+Thread.currentThread().getName());
                try {
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread.currentThread().interrupt();
    }
}

class Even implements Runnable{

    private Object lock;

    public void setLock(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        for(int i=0 ; i< 10; i = i+2){
            synchronized (lock){
                System.out.println(i + " "+Thread.currentThread().getName());
                try {
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        Thread.currentThread().interrupt();
    }
}
