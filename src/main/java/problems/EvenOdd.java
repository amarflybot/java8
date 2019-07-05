package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by amarendra on 31/01/18.
 */
public class EvenOdd {

    public static void main(final String[] args) throws IOException {
        final InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        final BufferedReader in = new BufferedReader(reader);
        String line;
        final StringBuilder stringBuilder = new StringBuilder();
        while ((line = in.readLine()) != null) {
            final String[] numbers = line.split("");
            for (int i = 0; i < numbers.length - 1; i++) {
                final String first = numbers[i];
                final String second = numbers[i + 1];
                if (checkOdd(first) && checkOdd(second)) {
                    stringBuilder.append(first).append("-");
                } else if (checkEven(first) && checkEven(second)) {
                    stringBuilder.append(first).append("*");
                } else {
                    stringBuilder.append(first);
                }
            }
            stringBuilder.append(numbers[numbers.length - 1]);
            System.out.println(stringBuilder);
        }
    }

    private static boolean checkOdd(final String str) {
        return Integer.parseInt(str) % 2 == 1;
    }

    private static boolean checkEven(final String str) {
        return Integer.parseInt(str) % 2 == 0;
    }
}
