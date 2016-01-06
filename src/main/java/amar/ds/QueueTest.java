package amar.ds;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amarendra on 06/01/16.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        System.out.println("1 "+queue);

        System.out.println("2 "+queue.peek());

        System.out.println("3 "+queue);

        System.out.println("4 "+queue.poll());

        System.out.println("5 "+queue);

        System.out.println("6 "+queue.remove());

        System.out.println("7 "+queue);

        System.out.println("8 "+queue.remove(4));

        System.out.println("9 "+queue);
    }

}
