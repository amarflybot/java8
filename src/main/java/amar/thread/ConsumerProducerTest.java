package amar.thread;

/**
 * Created by amarendra on 27/01/16.
 */
public class ConsumerProducerTest {

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[2];
        Thread even = new Thread(new EvenRunner(array), "EvenThread");
        Thread odd = new Thread(new OddRunner(array), "OddThread");
        even.start();
        odd.start();
        even.join();
        odd.join();

        System.out.println("All done !!");
    }
}

class EvenRunner implements Runnable {

    private int[] array;

    public EvenRunner(final int[] array) {
        this.array = array;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 10; ) {
            synchronized (array) {
                array[0] = i;
                array[1] = i+1;
                System.out.println("Added by Thread Name: " + Thread.currentThread().getName() + " - "+array[0]);
                System.out.println("Added by Thread Name: " + Thread.currentThread().getName() + " - "+array[1]);
                array.notify();
                try {
                    array.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i = i + 2;
        }

    }
}

class OddRunner implements Runnable {

    private int[] array;

    public OddRunner(final int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        while (array[0] != 0 || array[1] != 0){
            synchronized (array) {
                System.out.println("Removed by Thread Name: " + Thread.currentThread().getName() + " - "+array[0]);
                System.out.println("Removed By Thread Name: " + Thread.currentThread().getName() + " - "+array[1]);
                array[0] = 0;
                array[1] = 0;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                array.notify();
                try {
                    array.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
