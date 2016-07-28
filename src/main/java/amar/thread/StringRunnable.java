package amar.thread;

import java.util.concurrent.Callable;

/**
 * Created by kumarao on 28-01-2016.
 */
public class StringRunnable implements Callable<String> {

    @Override
    public String call() {
        return Thread.currentThread().getName();
    }
}
