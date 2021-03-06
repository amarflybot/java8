package amar.rx.filters;

import amar.rx.helper.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class PositionalExampleDistinct {

    public static void main(final String[] args) {

        final Observable<String> observable = Observable.from(DataGenerator.generateScrambleAndDuppedGreekAlphabet());

        observable.subscribe(letter -> {
            System.out.println(letter);
        });

        System.out.println("================================================================");
        observable.distinct().subscribe(letter -> {
            System.out.println(letter);
        });

        System.exit(0);

    }
}
