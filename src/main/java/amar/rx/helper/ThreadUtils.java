package amar.rx.helper;

/**
 * Created by amarendra on 20/10/16.
 */
public class ThreadUtils {

    public static void wait(Object object) {
        try {
            object.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // ignore
        }
    }

}
