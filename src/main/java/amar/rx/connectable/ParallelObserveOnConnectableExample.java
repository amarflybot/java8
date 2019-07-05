package amar.rx.connectable;

import amar.rx.helper.TimeTicker;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

/**
 * Created by amarendra on 20/10/16.
 */
public class ParallelObserveOnConnectableExample {

    public static void main(final String[] args) throws InterruptedException {

        final TimeTicker timeTicker = new TimeTicker(500);
        timeTicker.start();

        final ConnectableObservable<Long> connectable = timeTicker
                .toObservable()
                .publish();

        connectable
                .observeOn(Schedulers.computation())
                .subscribe((t) -> {
                    System.out.println("Tick1 : " + Thread.currentThread().getName() + " " + t);
                });

        connectable
                .observeOn(Schedulers.io())
                .subscribe((t) -> {
                    System.out.println("Tick2 : " + Thread.currentThread().getName() + " " + t);
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
