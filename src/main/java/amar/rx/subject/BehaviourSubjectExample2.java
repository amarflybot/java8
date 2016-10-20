package amar.rx.subject;

import amar.rx.helper.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by amarendra on 20/10/16.
 */
public class BehaviourSubjectExample2 {

    public static void main(String[] args) {

        BehaviorSubject<String> subject = BehaviorSubject.create("Start State");

        subject.subscribe((letter) -> {
            System.out.println("Subscribe 1: " + letter);

        });
        subject.subscribe(
                (letter) -> {
                    System.out.println("Subscriber 2: " + letter);
                },
                (t) -> {
                    subject.onError(t);
                },
                ()->{
                    System.out.println("Subscriber 2: Completed");
                    subject.onCompleted();
                });

        Observable.from(DataGenerator.generateGreekAlphabet())
                .subscribeOn(Schedulers.computation())
                .subscribe(
                        (letter) -> {
                            subject.onNext(letter);
                        },
                        (t) -> {
                            subject.onError(t);
                        },
                        ()->{
                            System.out.println("Subscriber 1: Completed");
                            subject.onCompleted();
                        });

        System.exit(0);
    }

}
