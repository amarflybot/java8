package amar.designPattern.structural.bridge;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by amarendra on 04/09/17.
 */
public class MyList<T> extends ArrayList<T> {

    private boolean oldSort;


    @Override
    public void sort(final Comparator<? super T> c) {
        if (oldSort){
            super.sort(c);
        }
    }
}
