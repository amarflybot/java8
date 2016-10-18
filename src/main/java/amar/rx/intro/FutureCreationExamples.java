package amar.rx.intro;

import amar.rx.helper.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.FutureTask;

/**
 * Created by amarendra on 16/10/16.
 */
public class FutureCreationExamples {

    public static void main(String[] args) {

        Observable<List<Integer>> listObservable;

        FutureTask<List<Integer>> futureTask = new FutureTask<List<Integer>>(()-> DataGenerator.generateArrayList());

        listObservable = Observable.from(futureTask);

        Schedulers.computation().createWorker().schedule(() -> {
           futureTask.run();
        });

        listObservable.subscribe((list) -> {
           list.forEach((i) -> {
               System.out.println(i);
           });
        });
    }
}
