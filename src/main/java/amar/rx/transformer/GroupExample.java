package amar.rx.transformer;

import amar.rx.helper.DataGenerator;
import rx.Observable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class GroupExample {

    public static final String EVEN = "EVEN";

    public static void main(String[] args) {

        List<Integer> iterable = DataGenerator.generateBigIntegerList();
        Collections.shuffle(iterable);
        Observable.from(iterable)
                .groupBy((i) -> {
                    return 0 == (i%2) ? EVEN : "ODD";
                })
                // Subscribe to the Observable<GroupedObservable<String, Integer>>
                .subscribe((groupList) ->{
                    System.out.println("Key: "+ groupList.getKey() + "-----------------------------------------");

                    groupList.subscribe((x) ->{
                        System.out.println(groupList.getKey() + " : " +x);
                    });
                });

        System.out.println("===============================================================================");

        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        Observable.from(iterable)
                .groupBy((i) -> {
                    return 0 == (i%2) ? EVEN : "ODD";
                })
                // Subscribe to the Observable<GroupedObservable<String, Integer>>
                .subscribe((groupList) ->{
                        groupList.subscribe(x -> {
                            if(groupList.getKey().equals(EVEN)){
                                evenList.add(x);
                            }
                            else {
                                oddList.add(x);
                            }

                    });
                });

        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("Even List -------------------------------------------");
        evenList.forEach(i ->{
            System.out.println(i);
        });
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Odd List -------------------------------------------");
        oddList.forEach(i -> {
            System.out.println(i);
        });

        System.exit(0);
    }
}
