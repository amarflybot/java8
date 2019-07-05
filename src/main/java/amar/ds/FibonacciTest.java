package amar.ds;

import java.util.Arrays;

/**
 * Created by amarendra on 16/02/16.
 */
public class FibonacciTest {

    public static void main(final String[] args) {
        final int[] integerStack = new int[7];
        integerStack[0] = 0;
        integerStack[1] = 1;
        final int[] fibonacci = findFibonacci(integerStack, 8, 1);
        System.out.println(Arrays.toString(fibonacci));
    }

    private static int[] findFibonacci(final int[] result, final int i, int j) {

        if (result[j] >= i) {
            return null;
        }
        result[j + 1] = (result[j] + result[j - 1]);
        j = j + 1;
        findFibonacci(result, i, j);
        return result;
    }


}
