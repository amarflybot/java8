package amar.functional;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by amarendra on 16/10/16.
 */
public class FirstClassCitizenVariableIllustration {

    public static void main(String[] args) {

        System.out.println(concatAndTransform("Hello ", "World Upper" , (s) -> s.toUpperCase()));

        Function<String, String> transformLower = (s) -> s.toLowerCase();

        System.out.println(concatAndTransform("Hello ", "World Lower", transformLower));

        System.out.println();

        BiFunction<String, String, String> concatFunction = (s, t) -> s+t;

        System.out.println(concatFunction.apply("Hello " , "World 1"));

        concatFunction = FirstClassCitizenVariableIllustration::concatStrings;
        System.out.println(concatFunction.apply("Hello ", "World 2"));

        FirstClassCitizenVariableIllustration firstClassCitizenVariableIllustration =
                new FirstClassCitizenVariableIllustration();
        concatFunction = firstClassCitizenVariableIllustration::concatStrings1;
        System.out.println(concatFunction.apply("Hello ", "World 3"));
    }

    private String concatStrings1(String s, String s1) {
        return s + s1;
    }

    private static String concatStrings(String s, String s1) {
        return s + s1;
    }

    private static String concatAndTransform(String s1, String s2, Function<String, String > stringTransform){

        if(stringTransform != null) {
            s1 = stringTransform.apply(s1);
            s2 = stringTransform.apply(s2);
        }
        return s1 + s2;
    }
}
