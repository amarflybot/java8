package amar.rx.intro;

import amar.rx.helper.DataGenerator;
import rx.Observable;

/**
 * Created by amarendra on 16/10/16.
 */
public class SimpleCreationExamples {

    public static void main(final String[] args) {

        Observable<Integer> observable;

        observable = Observable.from(new Integer[]{Integer.valueOf(42)});

        observable.subscribe((i) -> {
            System.out.println(i);
        });

        observable = Observable.from(DataGenerator.generateArrayList());

        observable.subscribe((i) -> {
            System.out.println(i);
        });
    }

}
