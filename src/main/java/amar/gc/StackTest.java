package amar.gc;

import java.util.Stack;

/**
 * Created by kumarao on 18-01-2016.
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < 10000; i++) {
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        while(true){
            //do something
        }

    }
}
