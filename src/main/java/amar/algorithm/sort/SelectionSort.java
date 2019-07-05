package amar.algorithm.sort;

import java.util.Arrays;

/**
 * Created by amarendra on 15/09/17.
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    private static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minPosition = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minPosition]) {
                    minPosition = j;
                }
            }
            int temp = arr[minPosition];
            arr[minPosition] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


}
