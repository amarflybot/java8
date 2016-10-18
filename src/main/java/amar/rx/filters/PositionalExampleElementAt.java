package amar.rx.filters;

import amar.rx.helper.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class PositionalExampleElementAt {

    public static void main(String[] args) {

        Observable<String> observable = Observable.from(DataGenerator.generateGreekAlphabet());

        observable.elementAt(2).subscribe((letter) -> {
            System.out.println(letter);
        });

        System.out.println("======================================");

        observable.elementAtOrDefault(50, "UNKNOWN").subscribe((letter) -> {
            System.out.println(letter);
        });

        System.exit(0);

    }
}
