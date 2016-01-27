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

    /**
     * @param orgNode
     * @param cloneNode
     * @param cloneNodeConst
     * @return
     */
    public Node<T> cloneRandom(Node<T> orgNode, Node<T> cloneNode, Node<T> cloneNodeConst){

        if(cloneNode == null){
            return null;
        }

        //Node<T> newNode = new Node<>();
        cloneNode.random = findNodeInClone(orgNode.random, cloneNodeConst);
        cloneRandom(orgNode.next, cloneNode.next, cloneNodeConst);

        return cloneNode;
    }

    private Node findNodeInClone(Node random, Node<T> cloneNode) {
        if (cloneNode == null){
           return null;
        }
        else if(random.data == cloneNode.data){
            return cloneNode;
        }
        else {
            cloneNode = cloneNode.next;
            return findNodeInClone(random, cloneNode);
        }

    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(4);
        singlyLinkedList.add(3);

        singlyLinkedList.head.random                = singlyLinkedList.head.next.next;
        singlyLinkedList.head.next.random           = singlyLinkedList.head.next.next.next;
        singlyLinkedList.head.next.next.random      = singlyLinkedList.head.next;
        singlyLinkedList.head.next.next.next.random = singlyLinkedList.head;

        singlyLinkedList.transverse();
        Node<Integer> clone = singlyLinkedList.clone(singlyLinkedList.head);
        Node<Integer> cloneRandom = singlyLinkedList.cloneRandom(singlyLinkedList.head, clone, clone);
        System.out.println(clone);
    }

}

class Node<T> {
    Node next;
    T data;
    Node random;
}
