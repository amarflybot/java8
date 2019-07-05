package amar.algorithm.general;

/**
 * Created by amarendra on 02/09/17.
 */
public class TestFor {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(j + " ");
            }

            System.out.println();
        }

    }
}
