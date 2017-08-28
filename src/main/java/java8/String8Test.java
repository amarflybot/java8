package java8;

import java.util.StringJoiner;

/**
 * Created by amarendra on 27/08/17.
 */
public class String8Test {

    public static void main(String[] args) {

        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("One");
        stringJoiner.add("Two");
        stringJoiner.add("Three");
        System.out.println(stringJoiner);
    }
}
