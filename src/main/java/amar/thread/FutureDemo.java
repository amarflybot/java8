package amar.thread;

import amar.io.FileReaderTest;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * Created by kumarao on 19-01-2016.
 */
public class FutureDemo {

    private static final ThreadFactory EXECUTOR = Executors.defaultThreadFactory();
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(3);
    private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        final Future<Integer> submit = cachedThreadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        final boolean done = submit.isDone();
        final Integer integer = submit.get();
        System.out.println(done);
        System.out.println(integer);
        final long startTime = System.currentTimeMillis();
        final FactorialCalculator factorialCalculatorTask = new FactorialCalculator(10);

        System.out.println("Submitting Task ...");
        final Future<Long> future = SCHEDULED_EXECUTOR_SERVICE.submit(factorialCalculatorTask);
        System.out.println("Submitted Task");

        while (!future.isDone()) {
            System.out.println("Task is not completed yet....");
            Thread.sleep(100);
            //sleep for 1 millisecond before checking again
        }

        System.out.println("Task is completed, let's check result");
        final Long factorial = future.get();
        System.out.println("Factorial of 10 is : " + factorial);
        SCHEDULED_EXECUTOR_SERVICE.shutdown();
        final long endTime = System.currentTimeMillis();
        System.out.println("Time Taken: " + (endTime - startTime));
    }
}

class FactorialCalculator implements Callable {

    private int number;

    public FactorialCalculator(final int number) {
        this.number = number;
    }

    @Override
    public Long call() {
        long output = 0;
        try {
            output = factorial(number);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }

    private long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 0) {
            Thread.sleep(100); // adding delay for example
            result = result * number;
            final FileReaderTest fileReaderTest = new FileReaderTest();
            try {
                FileReaderTest.main(new String[2]);
            } catch (final IOException e) {
                e.printStackTrace();
            }
            number--;
        }
        return result;
    }
}
