package amar.algorithm.general;

import java.util.Arrays;

/**
 * Created by amarendra on 16/09/17.
 */
public class FindNumberInSortedArray {

    static int noOfRounds;

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 0;

        boolean bool = find(arr,k);
        System.out.println("Found ? : "+ bool);
        System.out.println("Total Iterrations -> "+ noOfRounds);

    }

    private static boolean find(final int[] arr, final int k) {
        System.out.println("Considering Array -> "+ Arrays.toString(arr));
        noOfRounds++;
        final int length = arr.length;
        if (length == 0) {
            return false;
        }

        int midPoint = length / 2;
        if(k == arr[midPoint]){
            return true;
        }
        else if (k>arr[midPoint]){
            return find(Arrays.copyOfRange(arr, midPoint, length ), k);
        } else {
            return find(Arrays.copyOfRange(arr, 0, midPoint), k);
        }
    }
}
