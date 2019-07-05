package amar.rx.subject;

import amar.rx.helper.DataGenerator;
import amar.rx.helper.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by amarendra on 20/10/16.
 */
public class PublishSubjectExample {

    public static void main(String[] args) {

        Object signal = new Object();

        synchronized (signal) {

            PublishSubject<String> subject = PublishSubject.create();

            subject.subscribe((letter) -> {
                System.out.println("Subscribe 1: " + letter);

                ThreadUtils.sleep(500);

                if (letter.equals("eta")) {
                    synchronized (signal) {
                        signal.notify();
                    }
                }
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
                            () -> {
                                System.out.println("Subscriber 1: Completed");
                                subject.onCompleted();
                                synchronized (signal) {
                                    signal.notify();
                                }
                            });
            ThreadUtils.wait(signal);

            subject.subscribe(
                    (letter) -> {
                        System.out.println("Subscribe 2: " + letter);
                    },
                    (t) -> {
                        subject.onError(t);
                    },
                    () -> {
                        System.out.println("Subscriber 2: Completed");
                    });

            ThreadUtils.wait(signal);

        }

        System.exit(0);

    }
}
