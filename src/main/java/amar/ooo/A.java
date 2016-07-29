package amar.ooo;

import sun.awt.util.IdentityArrayList;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by amarendra on 28/07/16.
 */
public class A implements Y,X{
    @Override
    public Iterable<String> m(Iterable arg) {
        Iterable<String> it = new IdentityArrayList<>();
        it.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("In Consumer Accept");
            }
        });
        return it;
    }

    public static int sumWithCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.parallelStream()
                .filter(predicate)
                .mapToInt(i -> i)
                .sum();
    }
}
