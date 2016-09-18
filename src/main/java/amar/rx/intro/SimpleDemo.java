package amar.rx.intro;

import rx.Observable;
import rx.Subscription;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kumarao on 16-08-2016.
 */
public class SimpleDemo {

    public static void main(String[] args) {
        List<String> shapeList = Arrays.asList("rectangle", "square", "triangle");
        Observable<String> observableShape = Observable.from(shapeList);
        Subscription subscribe = observableShape.subscribe(new SimpleObserver());
    }
}
