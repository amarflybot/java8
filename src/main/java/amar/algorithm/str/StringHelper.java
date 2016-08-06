package amar.algorithm.str;

/**
 * Created by kumarao on 06-08-2016.
 */
public class StringHelper {
    public String reverseLast2Chars(String str) {
        int length = str.length();
        String rest = str.substring(0,length-2);
        char charAtSecondLast = str.charAt(length-2);
        char charAtLast = str.charAt(length-1);
        return rest+charAtLast+charAtSecondLast;
    }
}
