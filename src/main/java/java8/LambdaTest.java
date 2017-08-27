package java8;

import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by amarendra on 26/08/17.
 */
public class LambdaTest {

    public static void main(String[] args) {

        FileFilter fileFilter = pathname -> pathname.getName().endsWith(".java");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("i -> "+ i);
            }
        });

        List<String> list = Arrays.asList("Vicky", "Amar", "Alka", "Aammen");
        Collections.sort(list, Comparator.naturalOrder());

        Consumer<String> s1 = System.out::println;

        list.forEach(s1);
    }
}
