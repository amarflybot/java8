package amar.rx.subject;

import amar.rx.helper.DataGenerator;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by amarendra on 20/10/16.
 */
public class BehaviourSubjectExample2 {

    public static void main(final String[] args) {

        final BehaviorSubject<String> subject = BehaviorSubject.create("Start State");

        subject.subscribe((letter) -> {
            System.out.println("Subscribe 1: " + letter);

        });

        subject.subscribe((letter) -> {
            System.out.println("Subscribe 2: " + letter);

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
