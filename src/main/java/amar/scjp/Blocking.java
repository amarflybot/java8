package amar.scjp;


import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

class Blocking {
    Deque<String> gangOfFour = new LinkedBlockingDeque<String>();

    public static void main(final String[] args) {
        final Blocking blocking = new Blocking();
        blocking.new Consumer().start();
        blocking.new Producer().start();

    }

    class Producer extends Thread {
        String[] authors = {"E Gamma", "R Johnson", "R Helm", "J Vlissides"};

        public void run() {
            for (final String author : authors) {
                gangOfFour.add(author);

                try {
                    // take time to add
                    Thread.sleep(1000);
                } catch (final InterruptedException ie) {
                }
            }
        }
    }

    class Consumer extends Thread {
        int numOfAuthors = 4;
        // ignore it
        int processedAuthors = 0;

        public void run() {
            while (processedAuthors < 4) {
                while (gangOfFour.isEmpty()) { /*wait till an entry is inserted*/ }
                System.out.println(gangOfFour.remove());
                processedAuthors++;
            }
        }
    }
}

