package amar.rx.transformer;

import amar.rx.filters.TimeTicker;
import amar.rx.intro.DataGenerator;
import rx.Observable;
import rx.functions.Func1;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class ConditionalSkipExample {

    public static void main(String[] args) throws InterruptedException {


        Observable<String> sequence1 = Observable.interval(50, TimeUnit.MILLISECONDS)
                .repeat()
                .flatMap((Func1<Long, Observable<String>>) aLong -> Observable.from(DataGenerator.generateGreekAlphabet()));
        TimeTicker ticker = new TimeTicker(30000);

        sequence1.asObservable()
                .skipUntil(ticker.toObservable())
                .subscribe(ch -> {
                    System.out.println(ch);
                });

        ticker.start();
        sequence1.startWith("Amar");

        Thread.sleep(60000);

        System.exit(0);
    }
}
