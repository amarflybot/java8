package amar.code.creating_higher_order_functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Sample {
    public static int totalValues(final List<Integer> values, final Predicate<Integer> selector) {
        return values.stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }

    public static void main(final String[] args) {
        final List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println(totalValues(values, e -> true));
        System.out.println(totalValues(values, Sample::isEven));
        System.out.println(totalValues(values, Sample::isOdd));
        System.out.println(totalValues(values, e -> e > 3));
    }

    public static boolean isEven(final int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(final int number) {
        return number % 2 != 0;
    }
}

