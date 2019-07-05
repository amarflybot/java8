package amar.thread;

import java.util.concurrent.Callable;

/**
 * Created by kumarao on 28-01-2016.
 */
public class MyRunnable implements Callable<Long> {
    private final long countUntil;

    MyRunnable(final long countUntil) {
        this.countUntil = countUntil;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (long i = 1; i < countUntil; i++) {
            try {
                Thread.sleep(10);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
        }
        return sum;
    }
}
