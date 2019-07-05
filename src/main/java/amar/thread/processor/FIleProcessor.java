package amar.thread.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by amarendra on 23/10/17.
 */
public class FIleProcessor {

    public static void main(final String[] args) throws InterruptedException {

        final List<String> list = new ArrayList<>();

        final LineProcessor lineProcessor = new LineProcessor(list);
        final LineReader lineReader = new LineReader(list);

        final Thread lineProcessorThread = new Thread(lineProcessor, "LineProcessor-1");
        //Thread lineProcessorThread2 = new Thread(lineProcessor, "LineProcessor-2");
        //Thread lineProcessorThread3 = new Thread(lineProcessor, "LineProcessor-3");
        //final ExecutorService executorService = Executors.newFixedThreadPool(10);
        final Thread lineReaderThread = new Thread(lineReader, "LineReader-1");
        final Thread lineReaderThread1 = new Thread(lineReader, "LineReader-2");
        final Thread lineReaderThread2 = new Thread(lineReader, "LineReader-3");
        final Thread lineReaderThread3 = new Thread(lineReader, "LineReader-4");

        lineReaderThread.start();
        lineReaderThread1.start();
        lineReaderThread2.start();
        lineReaderThread3.start();
        //lineProcessorThread2.start();
        //lineProcessorThread3.start();
        lineProcessorThread.start();
        /*for (int i = 0; i < 10; i++) {
            executorService.submit(lineProcessor);
        }*/

        lineReaderThread.join();
        System.out.println("All Done!!");
        lineReaderThread.stop();
        System.exit(0);
    }

}


class LineProcessor implements Runnable {

    private final List<String> list;

    public LineProcessor(final List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (list.size() > 0) {
                    final Iterator<String> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        final String str = iterator.next();
                        System.out.println("Line Printed: " + str + " by thread " + Thread.currentThread().getName());
                        iterator.remove();
                    }
                    list.notify();
                    try {
                        list.wait();
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


class LineReader implements Runnable {

    private final List<String> list;

    public LineReader(final List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new java.io.FileReader(new File("/Users/amarendra/IdeaProjects/java8/src/main/res/amar.txt")));
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            synchronized (list) {
                if (list.size() > 3) {
                    final String line;
                    try {
                        assert bufferedReader != null;
                        line = bufferedReader.readLine();
                        System.out.println("Line Read: " + line + " by thread " + Thread.currentThread().getName());
                    } catch (final IOException e) {
                        break;
                    }
                    list.notify();
                    try {
                        list.wait();
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        Thread.sleep(10);
                    } catch (final InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(line);
                }
            }
        }
    }
}
