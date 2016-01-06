package amar.ds;

import java.util.Stack;

/**
 * Created by amarendra on 06/01/16.
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);

        System.out.println(stack.add(7));

        System.out.println(stack);
    }

}
