package amar.rx.filters;

import amar.rx.helper.TimeTicker;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class TimeBasedExampleSample {

    public static void main(String[] args) {

        TimeTicker timeTicker = null;
        try {
            timeTicker = new TimeTicker(10);
            timeTicker.start();

            timeTicker.toObservable()
                    .sample(1, TimeUnit.SECONDS)
                    .subscribe((t) -> {
                        System.out.println("Tick: " + t);
                    });

            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //Do nothing
        } finally {
            timeTicker.stop();
        }

        System.exit(0);

    }
}
