package problems;

/**
 * Created by amarendra on 31/01/18.
 */
public class BinaryAddition {

    public static void main(String[] args) {

        String input0 = "1010";
        String input1 = "10";

        int num0 = Integer.parseInt(input0, 2);
        int num1 = Integer.parseInt(input1, 2);

        int sum = num0 + num1;

        System.out.println(sum);
        System.out.println(Integer.toBinaryString(sum));
    }
}
