package amar.thread;

import java.util.concurrent.*;

/**
 * Created by kumarao on 19-01-2016.
 */
public class FutureDemo {

    private static final ExecutorService executor = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        long startTime = System.currentTimeMillis();
        FactorialCalculator factorialCalculatorTask = new FactorialCalculator(10);

        System.out.println("Submitting Task ...");
        Future<Long> future = executor.submit(factorialCalculatorTask);
        System.out.println("Submitted Task");

        while (!future.isDone()) {
            System.out.println("Task is not completed yet....");
            Thread.sleep(1);
            //sleep for 1 millisecond before checking again
            }

        System.out.println("Task is completed, let's check result");
        Long factorial = future.get();
        System.out.println("Factorial of 100 is : " + factorial);
        executor.shutdown();
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
            number--;
        }
        return result;
    }
}
