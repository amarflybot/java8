package amar.rx.transformer;

import amar.rx.filters.TimeTicker;
import amar.rx.intro.DataGenerator;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.TimeInterval;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class ConditionalSkipExample {

    public static void main(String[] args) throws InterruptedException {


        Observable<String> sequence1 = Observable.interval(50l, TimeUnit.MILLISECONDS)
                .timeInterval()
                .flatMap(new Func1<TimeInterval<Long>, Observable<String>>() {
                    @Override
                    public Observable<String> call(TimeInterval<Long> longTimeInterval) {
                        return Observable.from(DataGenerator.generateGreekAlphabet());
                    }
                });
        TimeTicker ticker = new TimeTicker(3000l);

        ticker.start();

        sequence1.asObservable()
                .skipUntil(ticker.toObservable())
                //.takeUntil(ticker.toObservable())
                .subscribe(ch -> {
                    System.out.println(ch);
                });

        //sequence1.startWith("Amar");

        Thread.sleep(6000l);

        System.exit(0);
    }
}
