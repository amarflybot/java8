package problems;

/**
 * Created by amarendra on 19/09/17.
 * <p>
 * Count numbers from 1 to n that have 4 as a digit
 * <p>
 * Given a number n, find count of all numbers from 1 to n that have 4 as a a digit.
 */
public class CountNumbersFrom1toN {

    public static void main(final String[] args) {

        final int c = count(328);
        System.out.println(c);

    }

    private static int count(final int n) {

        int numbers = 0;

        for (int i = 0; i <= n; i++) {
            if (hasNum(i)) {
                numbers = numbers + 1;
            }
        }

        return numbers;
    }

    private static boolean hasNum(int num) {

        while (num > 0) {
            final int res = num % 10;
            if (res == 4) {
                return true;
            }
            num = num / 10;
        }

        return false;
    }
}
