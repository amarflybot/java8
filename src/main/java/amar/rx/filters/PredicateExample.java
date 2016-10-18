package amar.rx.filters;

import amar.rx.helper.DataGenerator;
import rx.Observable;
import rx.Subscription;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class PredicateExample {

    public static void main(String[] args) {

        Subscription subscribe = Observable.from(DataGenerator.generateBigIntegerList())
                .filter((i) -> {
                    return ((i % 3) == 0 && (i < 20));
                })
                .subscribe((i) -> {
                    System.out.println(i);
                });

        System.exit(0);
    }
}
