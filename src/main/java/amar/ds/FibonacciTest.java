package amar.ds;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by amarendra on 16/02/16.
 */
public class FibonacciTest {

    public static void main(String[] args) {
        int [] integerStack = new int [7];
        integerStack[0] = 0;
        integerStack[1] = 1;
        int[] fibonacci = findFibonacci(integerStack, 8, 1);
        System.out.println(Arrays.toString(fibonacci));
    }

    private static int[] findFibonacci(int[] result, int i, int j) {

        if(result[j] >= i){
            return null;
        }
        result[j+1] = (result[j]+result[j-1]);
        j = j+1;
        findFibonacci(result, i, j);
        return result;
    }


}
