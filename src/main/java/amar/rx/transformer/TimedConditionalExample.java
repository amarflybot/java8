package amar.rx.transformer;

import amar.rx.intro.DataGenerator;
import rx.Observable;

import java.util.List;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class TimedConditionalExample {

    public static void main(String[] args) throws InterruptedException {

        Observable<String> observable1 = Observable.from(DataGenerator.generateGreekAlphabet()).delay(50, TimeUnit.MILLISECONDS);
        Observable<String> observable2 = Observable.from(DataGenerator.generateEnglishAlphabet()).delay(100, TimeUnit.MICROSECONDS);



        Observable.amb(observable1,observable2)
                .subscribe(s -> {
                    System.out.println(s);
                });

        observable1.startWith("Amar");
        observable2.startWith("Nagendra");

        Thread.sleep(4000);

        System.exit(0);
    }
}
