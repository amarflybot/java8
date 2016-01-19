package amar.ds;

/**
 * Created by kumarao on 18-01-2016.
 */
public class SinglyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void add(T element){
        Node <T> nd= new Node<T>();
        nd.data = element;

        if(head == null){
            head = nd;
            tail = nd;
        } else {
            tail.next = nd;
            tail = nd;
        }
    }

    public void transverse(){
        Node<T> node = head;
        while (true){
            System.out.println(node.data);
            if(node.next == null){
                break;
            }
            node = node.next;
        }
    }

    public Node<T> clone(Node<T> node){

        if(node == null){
            return null;
        }

        Node<T> newNode = new Node<>();
        newNode.data = node.data;
        newNode.next = clone(node.next);

        return newNode;
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(4);
        singlyLinkedList.add(3);
        singlyLinkedList.transverse();
        Node<Integer> clone = singlyLinkedList.clone(singlyLinkedList.head);
        System.out.println(clone);
    }

}

class Node<T> implements Comparable<T>{
    Node next;
    T data;

    @Override
    public int compareTo(T o) {
        if(o == this.data){
            return 0;
        }
        else {
            return 1;
        }
    }
}
