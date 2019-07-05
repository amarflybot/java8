package problems;

/**
 * Created by amarendra on 19/09/17.
 * <p>
 * Swap Kth node from beginning with Kth node from end in a Linked List
 * <p>
 * Given a singly linked list, swap kth node from beginning with kth node from end.
 * Swapping of data is not allowed, only pointers should be changed.
 * This requirement may be logical in many situations where the linked list data part is huge
 * (For example student details line Name, RollNo, Address, ..etc).
 * The pointers are always fixed (4 bytes for most of the compilers).
 */
public class SwapKthNode {

    public static void main(String[] args) {

        SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        linkedList.printList();
        System.out.println("--------------------------");
        linkedList.swap(4);
        linkedList.printList();
    }

}

class SinglyLinkedList<T> {

    Node<T> head;
    int count;

    public void addLast(T data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node nodeCurr = head;
            while (nodeCurr.getNext() != null) {
                nodeCurr = nodeCurr.getNext();
            }
            nodeCurr.setNext(new Node(data));
        }
        count++;
    }

    public void removeLast() {
        if (head == null) {
            throw new IllegalArgumentException("This list is null");
        } else {
            Node nodeCurr = head;
            while (nodeCurr.getNext().getNext() != null) {
                nodeCurr = nodeCurr.getNext();
            }
            nodeCurr.setNext(null);
        }
        count--;
    }

    public Node<T>[] elementFromStart(int k) {
        Node<T>[] arr = new Node[2];
        if (head == null) {
            throw new IllegalArgumentException("The List is null");
        } else {
            Node node = head;
            for (int i = 1; i < k; i++) {
                arr[0] = node;
                arr[1] = node.getNext();
                node = node.getNext();
            }
            return arr;
        }
    }

    public Node<T>[] elementFromEnd(int k) {
        Node<T>[] arr = new Node[2];
        if (head == null) {
            throw new IllegalArgumentException("The List is null");
        } else {
            Node node = head;
            for (int i = 0; i < (count - k); i++) {
                arr[0] = node;
                arr[1] = node.getNext();
                node = node.getNext();
            }
            return arr;
        }
    }

    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.println(node);
            node = node.getNext();
        }
    }

    public void swap(int k) {
        // Find the kth node from beginning of linked list.
        // We also find previous of kth node because we need
        // to update next pointer of the previous.
        Node x = head;
        Node x_prev = null;
        for (int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        // Similarly, find the kth node from end and its
        // previous. kth node from end is (n-k+1)th node
        // from beginning
        Node y = head;
        Node y_prev = null;
        for (int i = 1; i < count - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }

        // If x_prev exists, then new next of it will be y.
        // Consider the case when y->next is x, in this case,
        // x_prev and y are same. So the statement
        // "x_prev->next = y" creates a self loop. This self
        // loop will be broken when we change y->next.
        if (x_prev != null)
            x_prev.next = y;

        // Same thing applies to y_prev
        if (y_prev != null)
            y_prev.next = x;

        // Swap next pointers of x and y. These statements
        // also break self loop if x->next is y or y->next
        // is x
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        // Change head pointers when k is 1 or n
        if (k == 1)
            head = y;

        if (k == count)
            head = x;

    }

    public Node getHead() {
        return head;
    }
}

class Node<T> {
    Node next;
    private T data;

    public Node(final T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public T getData() {
        return data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(final Node next) {
        this.next = next;
    }
}
