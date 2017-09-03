package amar.algorithm.list;

import java.util.Stack;

/**
 * Created by amarendra on 02/09/17.
 */
public class Test {

    public static void main(String[] args) {

        char [] chars =  new char[7];
        chars[0] = '5';
        chars[1] = '6';
        chars[2] = '7';
        chars[3] = '*';
        chars[4] = '+';
        chars[5] = '1';
        chars[6] = '-';

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            int anInt = 0;
            try {
                char aChar = chars[i];
                anInt = Integer.parseInt(String.valueOf(aChar));
                // This is an Integer
                // push to stack
                stack.push(anInt);
            } catch (NumberFormatException e) {
                // This is an operator
                char right = Character.forDigit(stack.pop(),10);
                char left = Character.forDigit(stack.pop(), 10);
                char operator = chars[i];
                int operated = operate(operator, left, right);
                stack.push(operated);
            }

        }

        System.out.println("result --> " + stack.pop());

    }

    public static int operate(char operator, char left, char right){

        switch (operator) {
            case '+':
                return (Character.getNumericValue(left) + Character.getNumericValue(right));
            case '-':
                return ((Character.getNumericValue(left) - Character.getNumericValue(right)));
            case '*':
                return ((Character.getNumericValue(left) * Character.getNumericValue(right)));
            default:
                throw new RuntimeException("Operator Not Found");
        }
    }

}
