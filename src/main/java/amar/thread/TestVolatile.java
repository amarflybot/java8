package amar.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by amarendra on 26/08/17.
 */
public class TestVolatile {

    public static void main(final String[] args) throws InterruptedException {

        final Test.Counter counter = new Test.Counter();
        final ExecutorService executorService = Executors.newFixedThreadPool(100);
        final Collection<TestRun> callableList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            final Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Run");
                }
            });
            callableList.add(new TestRun(counter));
        }

        executorService.invokeAll(callableList);
        executorService.shutdown();

    }
}

class TestRun implements Callable<Integer> {

    Test.Counter test;

    public TestRun(final Test.Counter test) {
        this.test = test;
    }

    @Override
    public Integer call() {
        final int increment = test.increment();
        System.out.println(increment);
        return increment;
    }
}

class Test {

    public static class Counter {

        private volatile int count = 0;

        public int increment() {
            count = count + 1;
            return count;
        }

        public int getCount() {
            return count;
        }

        public void resetCount() {
            count = 0;
        }

    }
}
