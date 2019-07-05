package amar.algorithm.general;

/**
 * Created by amarendra on 15/09/17.
 */
public class ReversalOfNumber {

    public static void main(final String[] args) {

        final int i = 123456;
        final int reverse = reverse(i);
        System.out.println(reverse);
    }

    private static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            final int leftNumber = num / 10;
            final int rightMost = num % 10;
            reversed = reversed * 10 + rightMost;
            num = leftNumber;
        }

        return reversed;

    }
}
