package amar.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amarendra on 06/01/16.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue);

        System.out.println(queue.poll());

        System.out.println(queue);
    }

}
