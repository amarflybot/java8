package amar.algorithm.sort;

import java.util.Arrays;

/**
 * Created by amarendra on 03/09/17.
 */
public class BubbleSortTest {

    public static void main(final String[] args) {

        final int[] ints = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Before Sort -> " + Arrays.toString(ints));

        bubbleSort(ints);

        System.out.println("After Sort -> " + Arrays.toString(ints));
    }

    private static void bubbleSort(final int[] arr) {
        final int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Then Swap
                    final int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


}
