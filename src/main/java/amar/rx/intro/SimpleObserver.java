package amar.rx.intro;

import rx.Observer;

/**
 * Created by kumarao on 16-08-2016.
 */
public class SimpleObserver implements Observer<String> {
    @Override
    public void onCompleted() {
        System.out.println("onCompleted");
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("onError");
    }

    @Override
    public void onNext(String string) {
        System.out.println("onNext " +string);
    }
}
