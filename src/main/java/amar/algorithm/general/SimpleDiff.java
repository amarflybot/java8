package amar.algorithm.general;

import java.util.Arrays;

/**
 * Created by amarendra on 02/09/17.
 * Find minimum difference between any two elements
 */
public class SimpleDiff {

    public static void main(final String[] args) {

        final int[] array = {1, 19, -4, 31, 38, 25, 100};

        Arrays.sort(array);

        final int[] pair = new int[2];

        int diffRes = array[1] - array[0];

        for (int i = 0; i < array.length - 1; i++) {
            int diff = array[i + 1] - array[i];
            if (diff < 0) {
                diff = diff * -1;
            }
            if (diff <= diffRes) {
                diffRes = diff;
                pair[0] = array[i];
                pair[1] = array[i + 1];
            }
        }

        System.out.println(diffRes);
        System.out.println(Arrays.toString(pair));
    }
}
