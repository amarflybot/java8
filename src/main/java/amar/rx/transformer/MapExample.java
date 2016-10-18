package amar.rx.transformer;

import amar.rx.intro.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class MapExample {

    public static void main(String[] args) {

        Observable<String> observable = Observable.from(DataGenerator.generateGreekAlphabet());

        observable.map((letter) -> {
            return letter.toUpperCase();
        })
        .subscribe((letterString) ->{
            System.out.println(letterString);
        });
        System.out.println("========================================================");

        observable.flatMap((letter) -> {
           String[] returnString = {
                   letter.toUpperCase(), letter.toLowerCase()
           };
            return Observable.from(returnString);
        })
        .subscribe((letterString) ->{
            System.out.println(letterString);
        });
    }
}
