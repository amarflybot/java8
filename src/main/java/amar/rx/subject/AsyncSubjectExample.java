package amar.rx.subject;

import amar.rx.helper.DataGenerator;
import rx.Observable;
import rx.subjects.AsyncSubject;

/**
 * Created by amarendra on 20/10/16.
 */
public class AsyncSubjectExample {

    public static void main(String[] args) {

        AsyncSubject<String> subject = AsyncSubject.create();

        subject.subscribe((letter) -> {
            System.out.println("Subscribe 1: " + letter);

        });

        Observable.from(DataGenerator.generateGreekAlphabet())
                .subscribe(
                        (letter) -> {
                            subject.onNext(letter);
                        },
                        (t) -> {
                            subject.onError(t);
                        },
                        () -> {
                            System.out.println("On Completed");
                            subject.onCompleted();
                        });

        System.exit(0);
    }

}
