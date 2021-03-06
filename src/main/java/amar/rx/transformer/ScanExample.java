package amar.rx.transformer;

import amar.rx.helper.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class ScanExample {

    public static void main(final String[] args) {

        final Observable<String> observable = Observable.from(DataGenerator.generateGreekAlphabet());

        observable.scan(new StringBuilder(), (accumBuffer, nextLetter) -> {
            return accumBuffer.append(" ").append(nextLetter);
        })
                .subscribe((letter) -> {
                    System.out.println("Scan Event: " + letter);
                });

        System.out.println("===========================================================");

        observable.scan(new StringBuilder(), (accumBuffer, nextLetter) -> {
            return accumBuffer.append(" ").append(nextLetter);
        })
                .last()
                .subscribe((letter) -> {
                    System.out.println("Scan Event: " + letter);
                });

        System.out.println("===========================================================");

        System.exit(0);
    }
}
