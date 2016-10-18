package amar.rx.transformer;

import amar.rx.intro.DataGenerator;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class ConditionalExample {

    public static void main(String[] args) {

        Observable<Integer> integerObservable = Observable.from(DataGenerator.generatorFibonacciList(20));

        Observable.empty()
                .defaultIfEmpty("Hello World")
                .subscribe((str) ->{
                    System.out.println(str);
                });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Observable.from(DataGenerator.generateGreekAlphabet())
                .defaultIfEmpty("Hello World")
                .subscribe(str ->{
                    System.out.println(str);
                });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        integerObservable
                .skipWhile(i -> {
                    return i<8;
                })
                .subscribe(integer -> {
                    System.out.println(integer);
                });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        integerObservable
                .takeWhile(integer -> {
                    return integer <8;
                })
                .subscribe(integer -> {
                    System.out.println(integer);
                });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        integerObservable
                .zipWith(Observable.range(0, 3), (integer, integer2) -> {
                    return integer;
                })
                .subscribe(integer -> {
                    System.out.println(integer);
                });
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
