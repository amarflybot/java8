package amar.rx.transformer;

import amar.rx.helper.TimedEventSequence;
import amar.rx.helper.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class TimedConditionalExample {

    public static void main(String[] args) throws InterruptedException {


        TimedEventSequence<String> sequence1 = new TimedEventSequence<>(DataGenerator.generateGreekAlphabet(), 50);
        TimedEventSequence<String> sequence2 = new TimedEventSequence<>(DataGenerator.generateEnglishAlphabet(), 100);


        // Depending upon who has more frequency that takes precedence.
        Observable.amb(sequence1.toObservable(),sequence2.toObservable())
                .subscribe(s -> {
                    System.out.println(s);
                });

        sequence1.start();
        sequence2.start();

        Thread.sleep(4000);

        sequence1.stop();
        sequence2.stop();

        System.exit(0);
    }
}
