package amar.ooo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by amarendra on 25/07/16.
 */
public class Test {

    public static void main(String[] args) {

        Mammal mammal = new Person();
        mammal.walk(2);
        AtomicInteger atomicInteger = new AtomicInteger(8);
        int addAndGet = atomicInteger.addAndGet(6);
    }
}
