package amar.rx.connectable;

import amar.rx.helper.TimeTicker;
import rx.observables.ConnectableObservable;

/**
 * Created by amarendra on 20/10/16.
 */
public class BasicConnectableExample {

    public static void main(String[] args) throws InterruptedException {

        TimeTicker timeTicker = new TimeTicker(500);
        timeTicker.start();

        ConnectableObservable<Long> connectable = timeTicker
                .toObservable()
                .publish();

        connectable
                .subscribe((t) -> {
                    System.out.println("Tick: " + Thread.currentThread().getName() + " " + t);
                });

        System.out.println("Sleep for 3 seconds");
        Thread.sleep(3000);

        System.out.println("Connecting.....");
        connectable.connect();

        Thread.sleep(3000);
        System.out.println("Three seconds are up!");

        timeTicker.stop();
        System.exit(0);
    }
}
