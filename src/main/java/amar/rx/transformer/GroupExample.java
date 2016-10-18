package amar.rx.transformer;

import amar.rx.intro.DataGenerator;
import rx.Observable;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class GroupExample {

    public static void main(String[] args) {

        Observable.from(DataGenerator.generateBigIntegerList())
                .groupBy((i) -> {
                    return 0 == (i%2) ? "EVEN" : "ODD";
                })
                // Subscribe to the Observable<GroupedObservable<String, Integer>>
                .subscribe((groupList) ->{
                    System.out.println("Key: "+ groupList.getKey() + "-----------------------------------------");

                    groupList.subscribe((x) ->{
                        System.out.println(groupList.getKey() + " : " +x);
                    });
                });

    }
}
