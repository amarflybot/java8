package amar.codec;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by amarendra on 25/05/16.
 */
public class Test {

    public static void main(String[] args) {

        m1("sdfgh");
    }

    public static void m1(String s){
        System.out.println("In m1");
    }

    public static void m1(Object o1){
        System.out.println("In m2");
    }
}
