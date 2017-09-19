package amar.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by amarendra on 19/09/17.
 */
public class ReadFileInSync {

    public static void main(String[] args) throws InterruptedException {

        File file = new File("/Users/amarendra/IdeaProjects/java8/src/main/res/sample.csv");
        FileReaderMy fileReader = new FileReaderMy(file);
        List<String> records = new ArrayList<>();
        System.out.println("Starting RecordProcessor");
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(new RecordProcessor(fileReader,records));
            t1.start();
        }

        System.out.println("Starting RecordAccumulator");
        Thread t1 = new Thread(new RecordAccumulator(records), "Thread-RecordAccumulator:");
        t1.start();
        t1.join();

        System.out.println("All Done !");

    }
}

class RecordAccumulator implements Runnable{

    private List<String> strings;

    public RecordAccumulator(final List<String> strings) {
        this.strings = strings;
    }

    @Override
    public void run() {
        synchronized (strings) {
            while (strings.size() >= 10 || strings.size()>0) {
                for (int i = 0; i < strings.size(); i++) {
                    System.out.println("result processing by Thread: " + strings.get(i)
                            + " in thread " + Thread.currentThread().getName());
                    strings.remove(i);
                }
                strings.notify();
                try {
                    strings.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class RecordProcessor implements Runnable{

    private FileReaderMy fileReaderMy;
    private List<String> strings;

    public RecordProcessor(final FileReaderMy fileReaderMy, final List<String> records) {
        this.fileReaderMy = fileReaderMy;
        this.strings = records;
    }

    @Override
    public void run() {
        while (!fileReaderMy.isFileover()) {
            synchronized (strings) {
                String line = null;
                try {
                    line = fileReaderMy.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Processing line by Thread name -> " + Thread.currentThread().getName());
                this.strings.add(line);
                if (this.strings.size() >= 10) {
                    strings.notify();
                    try {
                        strings.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class FileReaderMy{

    private File file;

    private BufferedReader bufferedReader;
    private AtomicBoolean fileOver = new AtomicBoolean(false);

    public File getFile() {
        return file;
    }

    public boolean isFileover() {
        return fileOver.get();
    }

    public FileReaderMy(final File file) {
        this.file = file;
        java.io.FileReader fileReader = null;
        try {
            fileReader = new java.io.FileReader(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public String readLine() throws IOException {
        synchronized (file) {
            final String line = bufferedReader.readLine();
            if (line != null) {
                return line;
            } else {
                fileOver.set(true);
            }
            return null;
        }
    }

}
