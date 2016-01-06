package amar.ds;

import java.io.Serializable;
import java.util.Stack;

/**
 * Created by amarendra on 06/01/16.
 */
public class StackAsQueueTest {

    public static void main(String[] args) {

        StackAsQueue<Integer> stackAsQueue = new StackAsQueue();
        stackAsQueue.push(1);
        stackAsQueue.push(2);
        stackAsQueue.push(3);
        stackAsQueue.push(4);
        stackAsQueue.push(5);
        stackAsQueue.push(6);

        System.out.println(stackAsQueue);

        stackAsQueue.pop();
        stackAsQueue.pop();

        System.out.println(stackAsQueue);

    }

}

class StackAsQueue<T> implements Serializable, Cloneable{

    private Stack<T> stack1 = new Stack<>();

    public void push(T t){
        stack1.push(t);
    }

    public T pop(){
        T result = null;
        if (stack1.size()>0) {
            result = stack1.get(0);
            stack1.remove(0);
        }
        return result;
    }

    @Override
    public String toString() {
        return stack1.toString();
    }
}
