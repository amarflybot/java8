package amar.algorithm.str;

/**
 * Created by kumarao on 06-08-2016.
 */
public class StringHelper {
    public String reverseLast2Chars(final String str) {
        final int length = str.length();
        final String rest = str.substring(0, length - 2);
        final char charAtSecondLast = str.charAt(length - 2);
        final char charAtLast = str.charAt(length - 1);
        return rest + charAtLast + charAtSecondLast;
    }
}
