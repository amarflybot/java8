package amar.algorithm.sort;

import java.util.Arrays;

/**
 * Created by amarendra on 24/06/16.
 */
public class MergeSortTest {

    public static void main(String[] args) {

        //1D
        int[] arr = {3, 8, 4, 1, 2, 9, 5, 6};

        System.out.println("UnSorted arr -> " + Arrays.toString(arr));

        int[] sort = mergeSort(arr);

        System.out.println("Sorted arr -> " + Arrays.toString(sort));

    }

    private static int[] mergeSort(int[] arr) {

        //System.out.println("Considering arr -> " + Arrays.toString(arr));
        //Base case
        if (arr.length < 2) {
            return arr;
        }

        // Find Midpoint
        int length = arr.length;
        int midPoint = length / 2;

        int[] firstHalf = Arrays.copyOfRange(arr, 0, midPoint);
        int[] secondHalf = Arrays.copyOfRange(arr, midPoint, length);

        int[] left = mergeSort(firstHalf);
        int[] right = mergeSort(secondHalf);

        arr = merge(left, right);

        //System.out.println(Arrays.toString(arr));

        return arr;
    }

    private static int[] merge(final int[] firstHalf, final int[] secondHalf) {
        int[] array = new int[firstHalf.length + secondHalf.length];
        int i = 0, j = 0, k = 0;

        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i] < secondHalf[j]) {
                array[k] = firstHalf[i];
                k++;
                i++;
            } else {
                array[k] = secondHalf[j];
                k++;
                j++;
            }
        }
        // First Array is over
        while (j < secondHalf.length) {
            array[k] = secondHalf[j];
            k++;
            j++;
        }

        // Second Array is over
        while (i < firstHalf.length) {
            array[k] = firstHalf[i];
            k++;
            i++;
        }

        return array;
    }
}
