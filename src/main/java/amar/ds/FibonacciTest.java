package amar.ds;

import java.util.Set;
import java.util.Stack;

/**
 * Created by amarendra on 16/02/16.
 */
public class FibonacciTest {

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(0);
        integerStack.push(1);
        Stack<Integer> result = findFibonacci(integerStack, 8);
        System.out.println(result);
    }

    private static Stack<Integer> findFibonacci(Stack<Integer> result, int i) {

        if(result.peek() >= i){
            return null;
        }
        result.push(result.get(result.size()-2)+result.peek());
        findFibonacci(result, i);
        return result;
    }


}
