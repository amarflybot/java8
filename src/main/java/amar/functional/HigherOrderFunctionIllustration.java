package amar.functional;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by amarendra on 16/10/16.
 */
public class HigherOrderFunctionIllustration {

    public static void main(String[] args) {

        Supplier<String> combineAndTransform = createCombineAndTransform("Hello ", "World ", (s) -> s.toUpperCase());
        System.out.println(combineAndTransform.get());

    }

    private static Supplier<String> createCombineAndTransform(
            final String a, final String b,
            final Function<String, String> transformer
            ){
        return () -> {
            String aa = a;
            String bb = b;

            if(transformer != null){
                aa = transformer.apply(a);
                bb = transformer.apply(b);
            }
            return aa + bb;
        };
    }
}
