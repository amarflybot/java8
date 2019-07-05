package amar.test;

/**
 * Created by amarendra on 20/10/17.
 */
public class StringTest {

    public static void main(String[] args) {

        String str1 = "ABC";
        String str2 = "BAC";

        String rev = "";
        for (int i = 1; i <= str1.length(); i++) {
            rev = rev.concat(String.valueOf(str1.charAt(str1.length() - i)));
        }

        System.out.println(str1);
        System.out.println(rev);
    }
}
