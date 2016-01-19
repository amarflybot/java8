package amar.ds;

/**
 * Created by kumarao on 18-01-2016.
 */
public class SinglyLinkedList {

    public static void main(String[] args) {

    }

    public Node clone(Node node, boolean firstElement){
        Node node1 = null;
        if(firstElement){
            node1 = new Node(node.data);
        }
        node1.next = node.next;
        node = node.next;

        return clone(node, false);

    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
}
