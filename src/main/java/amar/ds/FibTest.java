package amar.ds;

/**
 * Created by amarendra on 06/09/17.
 */
public class FibTest {

    static int n1 = 0, n2 = 1, n3 = 0;

    private static void printFib(final int count) {
        if (count > 0) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;

            System.out.println(" " + n3);
            printFib(count - 1);
        }
    }

    private static int fact(final int n) {

        if (n == 1) {
            return 1;
        }

        return fact(n - 1) * n;

    }

    public static void main(final String[] args) {

        final int count = 10;
        //System.out.print(n1+ " "+ n2);
        //printFib(count-2);
        final int result = fact(4);
        System.out.println(result);

    }

}
