package amar.rx.filters;

import amar.rx.helper.TimeTicker;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class TimeBasedExampleTimeout {

    public static void main(final String[] args) {

        TimeTicker timeTicker = null;
        try {
            timeTicker = new TimeTicker(100);
            timeTicker.start();

            timeTicker.toObservable()

                    //We will timeout if the ticker stops for more than 3 seconds..
                    // an onError will be generated.
                    .timeout(3, TimeUnit.SECONDS)
                    .subscribe((t) -> {
                                System.out.println("Tick: " + t);
                            },
                            (exception) -> {
                                System.out.println("TIMEOUT!");
                                exception.printStackTrace();
                            }
                    );

            Thread.sleep(1000);

            System.out.println("Pausing Ticker.");
            timeTicker.pause();

            // Wait for another 5 seconds when 3 seconds are there for timeout.
            Thread.sleep(5000);

        } catch (final InterruptedException e) {
            //Do nothing
        } finally {
            timeTicker.stop();
        }

        System.exit(0);

    }
}
