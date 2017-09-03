package amar.algorithm.general;

/**
 * Created by amarendra on 02/09/17.
 *
 Maximum sum of a path in a Right Number Triangle

 Given a right triangle of numbers, find the largest of the sum of numbers that appear on the paths starting
 from the top towards the base, so that on each path the next number is located directly below or below-and-one-place-to-the-right.

 Input :1
        1 2
        4 1 2
        2 3 1 1
 Output : 9
 Explanation : 1 + 1 + 4 + 3

 Input :2
        4 1
        1 2 7
 Output : 10
 Explanation : 2 + 1 + 7

 */
public class RightNumberTriangle {

    public static void main(String[] args) {

        int[][] triangle = new int[4][4];
        triangle[0][0] = 1;
        triangle[1][0] = 1;
        triangle[1][1] = 2;
        triangle[2][0] = 4;
        triangle[2][1] = 1;
        triangle[2][2] = 2;
        triangle[3][0] = 2;
        triangle[3][1] = 3;
        triangle[3][2] = 1;
        triangle[3][3] = 1;

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println("");
        }
        int res = 0;
        for (int i = 0; i <= 3; i++) {
            int max = 0;
            for (int j = 0; j <= i; j++) {
                if (max < triangle[i][j]){
                    max = triangle[i][j];
                }
            }
            System.out.println("Adding -> " + max);
            res = res + max;
        }

        System.out.println("Result -> "+ res);
    }

}
