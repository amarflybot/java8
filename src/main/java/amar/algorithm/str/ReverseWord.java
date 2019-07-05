package amar.algorithm.str;

/**
 * Created by amarendra on 02/09/17.
 * <p>
 * Reverse words in a given string
 * <p>
 * Example: Let the input string be “i like this program very much”. The function should change the string to “much very program this like i”
 */
public class ReverseWord {

    public static void main(String[] args) {

        String str = "i like this program very much";

        String[] strings = new String[6];
        int j = 0;
        int k = 0;
        for (int i = 0; i < str.length() - 1; i++) {

            String substring = str.substring(i, i + 1);
            if (substring.equals(" ")) {
                strings[k] = str.substring(j, i);
                k++;
                j = i + 1;
            }
        }
        strings[k] = str.substring(j, str.length());
        System.out.println(strings);
    }
}
