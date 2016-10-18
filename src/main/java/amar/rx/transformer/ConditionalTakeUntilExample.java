package amar.rx.transformer;

import amar.rx.helper.DataGenerator;
import amar.rx.helper.TimeTicker;
import amar.rx.helper.TimedEventSequence;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class ConditionalTakeUntilExample {

    public static void main(String[] args) throws InterruptedException {

        TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
        TimeTicker ticker = new TimeTicker(3000);

        sequence1.toObservable()
                .takeUntil(ticker.toObservable())
                .subscribe(ch -> {
                    System.out.println(ch);
                });

        ticker.start();
        sequence1.start();

        Thread.sleep(6000);

        sequence1.stop();
        ticker.stop();
        System.exit(0);
    }
}
