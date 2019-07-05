package problems;

/**
 * Created by amarendra on 31/01/18.
 */
public class BinaryAddition {

    public static void main(final String[] args) {

        final String input0 = "1010";
        final String input1 = "10";

        final int num0 = Integer.parseInt(input0, 2);
        final int num1 = Integer.parseInt(input1, 2);

        final int sum = num0 + num1;

        System.out.println(sum);
        System.out.println(Integer.toBinaryString(sum));
    }
}
