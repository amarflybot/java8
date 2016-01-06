package amar.ds;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amarendra on 06/01/16.
 */
public class QueueAsStackTest {

    public static void main(String[] args) {

        QueueAsStack<Integer> queueAsStack = new QueueAsStack();
        queueAsStack.push(1);
        queueAsStack.push(2);
        queueAsStack.push(3);
        queueAsStack.push(4);
        queueAsStack.push(5);
        queueAsStack.push(6);

        System.out.println(queueAsStack);

        System.out.println(queueAsStack.poll());

        System.out.println(queueAsStack);

        System.out.println(queueAsStack.poll());

        System.out.println(queueAsStack);

        queueAsStack.push(7);

        System.out.println(queueAsStack);

        queueAsStack.push(8);

        System.out.println(queueAsStack);
    }
}

class QueueAsStack<T> implements Serializable, Cloneable{

    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T t){
        queue1.add(t);
    }

    public T poll(){
        int size = queue1.size();
        for(int i = 0; i < size-1; i++){
            if (size > 1) {
                queue2.add(queue1.peek());
            }
            queue1.remove();
        }
        T result = queue1.poll();
        queue1 = queue2;
        return result;
    }

    @Override
    public String toString() {
        return queue1.toString();
    }
}
