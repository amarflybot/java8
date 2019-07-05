package amar.algorithm.general;

import java.util.Arrays;

/**
 * Created by amarendra on 16/09/17.
 */
public class FindFloorValueInSortedArray {

    static int noOfRounds;

    public static void main(final String[] args) {

        final int[] arr = {1, 3, 6, 9, 12, 45, 67, 78};
        final int k = 11;

        final int i = floor(arr, k);
        System.out.println("Found ? : " + i);
        System.out.println("Total Iterrations -> " + noOfRounds);

    }

    private static int floor(final int[] arr, final int k) {
        System.out.println("Considering Array -> " + Arrays.toString(arr));
        noOfRounds++;
        final int length = arr.length;

        final int midPoint = length / 2;
        if (length == 1) {
            // found element
            return arr[0];
        } else if (length == 2) {
            // decide between left and right
            final int left = arr[0];
            final int right = arr[1];
            if ((k - left) < (right - k)) {
                return left;
            } else {
                return right;
            }
        } else if (calculateNearest(arr, midPoint, k)) {
            return floor(Arrays.copyOfRange(arr, midPoint - 1, length), k);
        } else {
            return floor(Arrays.copyOfRange(arr, 0, midPoint + 1), k);
        }
    }

    // If TRUE then consider Second Half
    // If FALSE then consider First Half.
    private static boolean calculateNearest(final int[] arr, final int midPoint, final int k) {
        final int leftToMid = arr[midPoint - 1];
        final int rightToMid = arr[midPoint + 1];
        if (k - leftToMid > rightToMid - k) {
            return false;
        } else {
            return true;
        }
    }
}
