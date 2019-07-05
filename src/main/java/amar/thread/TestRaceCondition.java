package amar.thread;

/**
 * Created by amarendra on 30/08/17.
 */
public class TestRaceCondition {

    public static void main(final String[] args) throws InterruptedException {

        final LongWrapper longWrapper = new LongWrapper(0l);

        final Runnable runnable = () -> {
            for (int i = 0; i < 1_000; i++) {
                longWrapper.increment();
            }
        };

        final Thread[] threads = new Thread[1_000];

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
