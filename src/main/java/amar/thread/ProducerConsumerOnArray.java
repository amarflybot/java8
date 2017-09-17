package amar.thread;

/**
 * Created by amarendra on 30/08/17.
 */
public class ProducerConsumerOnArray {

    static volatile Boolean aBoolean = Boolean.FALSE;

    public static void main(String[] args) throws InterruptedException {

        Integer[] integers = new Integer[2];


        Runnable producer = new ProducerThread(aBoolean, integers);
        Runnable consumer = new ConsumerThread(aBoolean, integers);

        Thread producerThread = new Thread(producer);
        producerThread.setName("Producer Thread");
        Thread consumerThread = new Thread(consumer);
        consumerThread.setName("Consumer Thread");
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}

class ProducerThread implements Runnable{

    private Boolean start;

    Integer[] integers;

    public ProducerThread(final Boolean start, final Integer[] integers) {
        this.start = start;
        this.integers = integers;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i = i+2) {
            synchronized (start) {
                this.integers[0] = i;
                this.integers[1] = i+1;
                start.notify();
                try {
                    start.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        start = Boolean.TRUE;

    }
}

class ConsumerThread implements Runnable{

    private Integer[] integers;
    private Boolean start;

    public ConsumerThread(final Boolean start , final Integer[] integers) {
        this.start = start;
        this.integers = integers;
    }

    @Override
    public void run() {
        synchronized (start) {
        while (start) {
                System.out.println(this.integers[0]);
                System.out.println(this.integers[1]);
                start.notify();
                try {
                    start.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
