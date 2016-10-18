package amar.rx.transformer;

import amar.rx.intro.DataGenerator;
import rx.Observable;
import rx.functions.Func1;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class TimedConditionalExample {

    public static void main(String[] args) throws InterruptedException {


        Observable<String> observable1 = Observable.interval(50,TimeUnit.MILLISECONDS)
                .repeat()
                .flatMap(new Func1<Long, Observable<String>>() {
                    @Override
                    public Observable<String> call(Long aLong) {
                        return Observable.from(DataGenerator.generateGreekAlphabet());
                    }
                });

        Observable<String> observable2 = Observable.interval(100,TimeUnit.MILLISECONDS)
                .repeat()
                .flatMap(new Func1<Long, Observable<String>>() {
                    @Override
                    public Observable<String> call(Long aLong) {
                        return Observable.from(DataGenerator.generateEnglishAlphabet());
                    }
                });


        // Depending upon who has more frequency that takes precedence.
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
