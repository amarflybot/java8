package amar.rx.using;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by amarendra on 20/10/16.
 */
public class JdbcUsingExample {

    public static void main(String[] args) {

        Action1<Throwable> errorHandler = (t) -> {
            t.printStackTrace();
        };

        TestDatabase.init();

        Func0<ConnectionSubscription> resourceFactory = () -> new ConnectionSubscription(TestDatabase.createConnection("jdbc:derby:rxJavaTest"));

        Func1<ConnectionSubscription, Observable<String>> geekAlphabetList =
                (connectionSubscription -> TestDatabase.selectGreekAlphabet(connectionSubscription));

        Action1<ConnectionSubscription> dispose = (connectionSubscription) -> {
            connectionSubscription.unsubscribe();
        };

        Observable<String> using = Observable.using(resourceFactory, geekAlphabetList, dispose);

        using.subscribe((letter) -> {
                    System.out.println(Thread.currentThread().getName() + " - " + letter);
                },
                errorHandler,
                () -> {
                    System.out.println("On Complete");
                });

    }
}
