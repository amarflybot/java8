package amar.thread;

/**
 * Created by amarendra on 30/08/17.
 */
public class TestRaceCondition {

    public static void main(String[] args) throws InterruptedException {

        LongWrapper longWrapper = new LongWrapper(0l);

        Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                longWrapper.increment();
            }
        };

        Thread[] threads = new Thread[1_000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("Value --> " + longWrapper.getL());
    }

}

class LongWrapper {

    private long l;

    public LongWrapper(final long l) {
        this.l = l;
    }

    public long getL() {
        return l;
    }

    public synchronized void increment() {
        l = l + 1;
    }
}
