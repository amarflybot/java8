package amar.algorithm.str;

import java.util.Arrays;

/**
 * Created by amarendra on 15/09/17.
 * Example: Let the input string be “i like this program very much”. The function should change the string to “much very program this like i”
 */
public class ReverseWordByOnBy2 {

    public static void main(String[] args) {

        String str = "i like this program very much";
        String[] strings = new String[6];
        final int length = str.length();
        int k = 0, j = 0;
        for (int i = 0; i < length; i++) {
            String charAt = str.substring(i, i + 1);
            if (charAt.equals(" ")) {
                strings[j] = str.substring(k, i);
                j++;
                k = i + 1;
            }
        }
        strings[j] = str.substring(k, str.length());

        System.out.println(Arrays.toString(strings));

        for (int i = 0; i < strings.length / 2; i++) {
            String temp = strings[i];
            final int i1 = strings.length - 1 - i;
            strings[i] = strings[i1];
            strings[i1] = temp;
        }

        System.out.println(Arrays.toString(strings));

    }
}
