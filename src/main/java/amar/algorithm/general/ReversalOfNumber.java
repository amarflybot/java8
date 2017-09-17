package amar.algorithm.general;

/**
 * Created by amarendra on 15/09/17.
 */
public class ReversalOfNumber {

    public static void main(String[] args) {

        int i = 123456;
        int reverse = reverse(i);
        System.out.println(reverse);
    }

    private static int reverse(int num) {
        int reversed = 0;
        while (num != 0){
            int leftNumber = num / 10;
            int rightMost = num % 10;
            reversed = reversed *10 + rightMost;
            num = leftNumber;
        }

        return reversed;

    }
}
