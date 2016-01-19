package amar.thread;

/**
 * This can be put into a Spring Bean
 * Created by kumarao on 19-01-2016.
 */
public class DeadlockLoggingBean implements Runnable {

    public void init() {
        Thread t = new Thread(this, "DeadlockLoggingBean");
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void run() {
        System.out.println("In Run Method of DeadlockLoggingBean");
        while (!Thread.currentThread().isInterrupted()) {
            String deadlock = ThreadManagement.detectDeadlocks();
            if (deadlock != null) {
                System.out.println("\007\007\007");
                System.out.println(deadlock + System.getProperty("line.separator"));
            }
            try {
                Thread.sleep(30000);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
