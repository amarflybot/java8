package amar.algorithm.sort;

import java.util.Arrays;

/**
 * Created by amarendra on 03/09/17.
 */
public class BubbleSortTest {

    public static void main(String[] args) {

        int [] ints = {9,8,7,6,5,4,3,2,1};
        System.out.println("Before Sort -> " + Arrays.toString(ints));

        bubbleSort(ints);

        System.out.println("After Sort -> "+ Arrays.toString(ints));
    }

    private static void bubbleSort(final int[] ints) {
        boolean swap = false;
        int numberOfIterations = 0;
        do {
            swap = false;
            for (int i = 0; i < ints.length-1; i++) {
                if (ints[i] > ints[i+1]){
                    swap = true;
                    int temp = ints[i];
                    ints[i] = ints[i+1];
                    ints[i+1]  = temp;

                    numberOfIterations++;
                }
            }
        } while (swap);
        System.out.println("Number of Iterations -> "+ numberOfIterations);
    }
}
