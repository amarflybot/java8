package problems;

/**
 * Created by amarendra on 19/09/17.
 * Print a given matrix in spiral form
 * Given a 2D array, print it in spiral form. See the following examples.
 * <p>
 * Input:
 * 1    2   3   4
 * 5    6   7   8
 * 9   10  11  12
 * 13  14  15  16
 * <p>
 * Output:
 * 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * <p>
 * Input:
 * 1   2   3   4  5   6
 * 7   8   9  10  11  12
 * 13  14  15 16  17  18
 * <p>
 * Output:
 * 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 */
public class SpiralForm {

    public static void main(final String[] args) {
        final int[][] arr = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        printSpiral(arr, 4, 4);
    }

    private static void printSpiral(final int[][] arr, final int m, final int n) {

        int i = 0;
        int k = 0;
        final int l = 0;

        while (k < m && l < n) {

            // first line
            for (i = k; i < n; i++) {
                System.out.println(arr[k][i] + " ");
            }
            k++;

            // right column line
            for (i = 0; i < m; i++) {
                System.out.println(arr[i][m] + " ");
            }

        }
    }
}
