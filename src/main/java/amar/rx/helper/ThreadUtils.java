package amar.rx.helper;

/**
 * Created by amarendra on 20/10/16.
 */
public class ThreadUtils {

    public static void wait(final Object object) {
        try {
            object.wait();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(final long time) {
        try {
            Thread.sleep(time);
        } catch (final InterruptedException e) {
            // ignore
        }
    }

}
