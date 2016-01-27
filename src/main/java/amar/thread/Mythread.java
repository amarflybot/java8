package amar.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class shows the detection of deadlock
 * Created by amarendra on 09/01/16.
 */
public class Mythread {
    static Object lock = new Object();
    static List<Integer> list = new ArrayList<>(3);
    //static Object lock2 = new Object();
    public static void main(String[] args) {

        /*DeadlockLoggingBean deadlockLoggingBean = new DeadlockLoggingBean();
        deadlockLoggingBean.init();*/

        Thread t1 = new Thread(new Runnable() {
            public void run() {

                //for (int itr = 1; itr < 51; itr = itr + 2) {

                while (true) {
                    synchronized (lock) {
                        list.add(new Random().nextInt());
                        list.add(new Random().nextInt());
                        list.add(new Random().nextInt());
                        System.out.println(" Thread1 list added");

                        //synchronized (lock2) {
                            try {
                                lock.notify();
                                System.out.println(" Thread1 waiting at acquire lock on lock2");
                                lock.wait();
                                for(int i = 2; i>=0; i--){
                                    Integer remove = list.remove(i);
                                    System.out.println(" Thread2 removed " + remove);
                                }
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        //}
                    }
                }
                //}
            }
        }, "Thread1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {

                //for (int itr = 2; itr < 51; itr = itr + 2) {
                while (true) {
                    synchronized (lock) {
                        for(int i = 2; i>=0; i--){
                            Integer remove = list.remove(i);
                            System.out.println(" Thread2 removed " + remove);
                        }


                        //synchronized (lock) {
                            try {
                                lock.notify();
                                /*if(itr==50)
                                    break;*/
                                System.out.println(" Thread2 waiting at acquire lock on lock");
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        //}
                    }
                }
                //}
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