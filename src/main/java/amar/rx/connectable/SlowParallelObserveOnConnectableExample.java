package amar.rx.connectable;

import amar.rx.helper.ThreadUtils;
import amar.rx.helper.TimeTicker;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

/**
 * Created by amarendra on 20/10/16.
 */
public class SlowParallelObserveOnConnectableExample {

    public static void main(String[] args) throws InterruptedException {

        TimeTicker timeTicker = new TimeTicker(500);
        timeTicker.start();

        ConnectableObservable<Long> connectable = timeTicker
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
                    ThreadUtils.sleep(1000);
                });

        System.out.println("Sleep for 3 seconds");
        ThreadUtils.sleep(3000);

        System.out.println("Connecting.....");
        connectable.connect();

        ThreadUtils.sleep(5000);
        System.out.println("Five seconds are up!");

        timeTicker.stop();

        ThreadUtils.sleep(6000);
        System.out.println("Notice how the second observer continued to process");
        System.exit(0);
    }
}
