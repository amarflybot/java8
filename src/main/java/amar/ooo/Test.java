package amar.ooo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by amarendra on 25/07/16.
 */
public class Test {

    public static void main(final String[] args) {

        final Mammal mammal = new Person();
        mammal.walk(2);
        final AtomicInteger atomicInteger = new AtomicInteger(8);
        final int addAndGet = atomicInteger.addAndGet(6);
        System.out.println(mammal.getNumber());
    }
}
