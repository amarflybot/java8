package amar.thread;

import amar.io.FileReaderTest;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * Created by kumarao on 19-01-2016.
 */
public class FutureDemo {

    private static final ThreadFactory EXECUTOR = Executors.defaultThreadFactory();
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);
    private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = Executors.newScheduledThreadPool(3);
    private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Future<Integer> submit = cachedThreadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        boolean done = submit.isDone();
        Integer integer = submit.get();
        System.out.println(done);
        System.out.println(integer);
        long startTime = System.currentTimeMillis();
        FactorialCalculator factorialCalculatorTask = new FactorialCalculator(10);

        System.out.println("Submitting Task ...");
        Future<Long> future = SCHEDULED_EXECUTOR_SERVICE.submit(factorialCalculatorTask);
        System.out.println("Submitted Task");

        while (!future.isDone()) {
            System.out.println("Task is not completed yet....");
            Thread.sleep(100);
            //sleep for 1 millisecond before checking again
            }

        System.out.println("Task is completed, let's check result");
        Long factorial = future.get();
        System.out.println("Factorial of 10 is : " + factorial);
        SCHEDULED_EXECUTOR_SERVICE.shutdown();
        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken: "+(endTime - startTime));
    }
}

class FactorialCalculator implements Callable{

    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call(){
        long output = 0;
        try {
            output =  factorial(number);
        } catch (InterruptedException e) {
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
            FileReaderTest fileReaderTest = new FileReaderTest();
            try {
                FileReaderTest.main(new String[2]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            number--;
        }
        return result;
    }
}
