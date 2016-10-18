package amar.rx.transformer;

import amar.rx.filters.TimeTicker;

import java.util.concurrent.TimeUnit;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class BufferExample {
    public static void main(String[] args) {

        TimeTicker timeTicker = new TimeTicker(100);
        timeTicker.start();

        timeTicker.toObservable()
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(
                        list -> {
                            System.out.println("---------------------------------------------");
                            int count = 1;
                            int size = list.size();
                            for (int i= 0 ; i< size; i++){
                                System.out.println(" " +  count++ + " : " + list.get(i));
                            }
                        }
                );
    }
}
