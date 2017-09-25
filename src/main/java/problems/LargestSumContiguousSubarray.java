package problems;

/**
 * Created by amarendra on 19/09/17.
 *
 * Largest Sum Contiguous Subarray
 *
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional
 * array of numbers which has the largest sum.
 */
public class LargestSumContiguousSubarray {

    public static void main(String[] args) {


        int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int tot = calculate(arr);

        System.out.println(tot);
    }

    private static int calculate(final int[] arr) {

        int maxEnd= 0, maxSoFar = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            maxEnd = maxEnd + arr[i];

            if (maxEnd < 0) {
                maxEnd = 0;
            }
            if (maxSoFar < maxEnd) {
                maxSoFar = maxEnd;
            }

        }

        return maxSoFar;
    }

}
