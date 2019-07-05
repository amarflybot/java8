package amar.algorithm.general;

/**
 * Created by amarendra on 02/09/17.
 * Given a integer as a input and replace all the ‘0’ with ‘5’ in the integer.
 * 102 - 152
 * 1020 - 1525
 */
public class ReplaceNum {

    public static void main(String[] args) {

        int num = 152;

        int replaced = findReplace(num);

        System.out.println(replaced);
    }

    private static int findReplace(final int num) {

        if (num == 0) {
            return 0;
        }

        int digit = num % 10;

        if (digit == 5) {
            digit = 0;
        }

        return findReplace(num / 10) * 10 + digit;
    }
}
