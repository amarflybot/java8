package amar.rx.intro;

import amar.rx.helper.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

/**
 * Created by amarendra on 16/10/16.
 */
public class SubscriptionAllOneThread {

    public static void main(final String[] args) throws InterruptedException {


        System.out.println("Current Thread 1 " + Thread.currentThread().getName());


        final List<Integer> integerList = DataGenerator.generateArrayList();

        final Observable<Integer> integerObservable = Observable.from(integerList);
        final Object waitMonitor = new Object();
        synchronized (waitMonitor) {
            integerObservable
                    .flatMap(integer -> Observable.just(integer)
                            .subscribeOn(Schedulers.io())
                            .doOnNext((xx) -> {
                                System.out.println("Parallel thread in " + Thread.currentThread().getName());
                                System.out.println("Parallel " + xx);
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println("Parallel thread out " + Thread.currentThread().getName());
                            }))
                    //.subscribeOn(Schedulers.io())
                    //.observeOn(Schedulers.io())
                    .subscribe((i) -> {
                                System.out.println("Thread Entered " + Thread.currentThread().getName());
                                System.out.println(i);
                                System.out.println("Thread Exited " + Thread.currentThread().getName());
                            },
                            (t) -> {
                                System.out.println("On Error " + Thread.currentThread().getName());
                                t.printStackTrace();
                            },
                            () -> {
                                System.out.println("On Complete " + Thread.currentThread().getName());
                                synchronized (waitMonitor) {
                                    waitMonitor.notify();
                                }
                            });
            waitMonitor.wait();
        }
    }
}
