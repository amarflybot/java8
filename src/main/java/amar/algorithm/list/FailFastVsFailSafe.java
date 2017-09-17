package amar.algorithm.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by amarendra on 15/09/17.
 */
public class FailFastVsFailSafe {

    public static void main(String[] args) {

        final List<String> stringList = new ArrayList<>();
        Arrays.asList("Amar","Vicky")
                .forEach(name -> stringList.add(name));

        final Iterator<String> iterator = stringList.iterator();
        try {
            while (iterator.hasNext()){
                System.out.println(iterator.next());
                stringList.add("Diff");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> strings = new CopyOnWriteArrayList<>();
        Arrays.asList("Amar1","Vicky1")
                .forEach(name -> strings.add(name));

        final Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()){
            System.out.println(stringIterator.next());
            strings.add("Diff1");
        }

        final Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
