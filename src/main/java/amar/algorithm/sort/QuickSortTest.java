package amar.algorithm.sort;

import java.util.Arrays;


/**
 * Created by amarendra on 18/09/17.
 */
public class QuickSortTest {

    public static void main(String[] args) {

        int[] arr = {7,2,1,6,8,5,3,4};
        System.out.println("Sorted array: "+ Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println("Sorted array: "+ Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex < endIndex) {

            int pIndex = partition(arr, startIndex, endIndex);
            //Sort left
            quickSort(arr, startIndex, pIndex - 1);

            //Sort Right
            quickSort(arr, pIndex + 1, endIndex);
        }
    }

    /**
     * Its job is to partition the array
     * @param arr
     * @param startIndex
     * @param endIndex
     * @return the partition index of array
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[endIndex];
        System.out.println("Considering pivot as: "+ pivot);
        int pIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] <= pivot){
                // Swap arr[i] and arr[pIndex] AND increase pIndex++
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
                pIndex++;
            }
        }
        // Swap the element at partition index and pivot
        arr[endIndex] = arr[pIndex];
        arr[pIndex] = pivot;
        return pIndex;
    }
}
