package amar.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by amarendra on 05/09/17.
 */
public class Test2 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Amar");
        names.add("Alka");
        names.add("Vicky");
        names.add("Deepak");

        /*for (String name: names ) {
            System.out.println(name);
            names.remove("Deepak");
        }*/

        /*names.forEach(name -> {
            System.out.println(name);
            names.remove("Deepak");
        });*/
        System.out.println("Before -> " +names);

        final Iterator<String> iterator = names.iterator();

        while (iterator.hasNext()) {
            final String next = iterator.next();
            if (next == "Deepak") {
                iterator.remove();
            } else
                System.out.println(next);
        }

        System.out.println("After -> " +names);

    }

}
