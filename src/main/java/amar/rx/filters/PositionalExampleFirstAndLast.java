package amar.rx.filters;

import amar.rx.helper.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class PositionalExampleFirstAndLast {

    public static void main(final String[] args) {

        final Observable<String> observable = Observable.from(DataGenerator.generateGreekAlphabet());

        observable.first().subscribe(letter -> {
            System.out.println(letter);
        });
        System.out.println("=========================================");
        observable.last().subscribe(letter -> {
            System.out.println(letter);
        });
        System.out.println("=========================================");
        observable.takeLast(4).subscribe(letter -> {
            System.out.println(letter);
        });
        System.out.println("=========================================");
        Observable.empty().firstOrDefault("List is Empty")
                .subscribe(letter -> {
                    System.out.println(letter);
                });
        System.out.println("=========================================");
        Observable.empty().lastOrDefault("List is Empty")
                .subscribe(letter -> {
                    System.out.println(letter);
                });

        System.exit(0);

    }
}
