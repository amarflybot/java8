package amar.algorithm.list;

import java.util.AbstractList;

/**
 * Created by amarendra on 02/09/17.
 */
public class DoublyLinkedList<T> extends AbstractList<T>{

    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    int count;

    public DoubleNode<T> getHead() {
        return head;
    }

    public void setHead(final DoubleNode<T> head) {
        this.head = head;
    }

    public DoubleNode<T> getTail() {
        return tail;
    }

    public void setTail(final DoubleNode<T> tail) {
        this.tail = tail;
    }

    public int getCount() {
        return count;
    }
    public void addFirst(T value) {
        addFirst(new DoubleNode<>(value));
    }

    public void addFirst(DoubleNode<T> node) {

        if (count == 0) {
            head = node;
            tail = head;
            count++;
            return;
        }

        DoubleNode<T> temp = head;

        head = node;
        head.setNext(temp);
        temp.setPrevious(head);
        count++;
        if (count == 1) {
            head.setNext(tail);
            tail.setPrevious(head);
        }
    }

    public void addLast(T val) {addLast(new DoubleNode<>(val));}
    public void addLast(DoubleNode<T> node){

        if (count == 0){
            head = tail;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        count++;

    }

    public T removeFirst(){
        T t = head.getValue();
        if (count != 0){
            if (count == 1) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
                head.setPrevious(null);
            }
            count--;
        }
        return t;
    }

    public T removeLast() {
        T val = tail.getValue();
        if (count != 0) {
            if (count == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.getPrevious();
                tail.setNext(null);
            }
            count--;
        }
        return val;
    }


    @Override
    public T get(final int index) {

        final DoubleNode<T> byIndex = getByIndex(index);
        return byIndex == null ? null : byIndex.getValue();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean add(final T t) {

        if (count == 0 ){
            addFirst(t);
        } else {
            addLast(t);
        }

        return true;
    }

    @Override
    public T remove(final int index) {
        final DoubleNode<T> byIndex = getByIndex(index);
        if (byIndex.getPrevious() == null){
            //this is first node
            byIndex.getNext().setPrevious(byIndex.getPrevious());
        } else if (byIndex.getNext() == null) {
            //this is last node
            byIndex.getPrevious().setNext(byIndex.getNext());
        } else {
            byIndex.getPrevious().setNext(byIndex.getNext());
            byIndex.getNext().setPrevious(byIndex.getPrevious());
        }
        count --;
        return byIndex.getValue();
    }

    public DoubleNode<T> getByIndex(final int index) {
        int i = 0;
        DoubleNode<T> currentNode = head;
        while (currentNode.getNext() != null){
            if (i == index){
                return currentNode;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return null;
    }
}

class DoubleNode<T> {

    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    public DoubleNode(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(final DoubleNode<T> next) {
        this.next = next;
    }


    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(final DoubleNode<T> previous) {
        this.previous = previous;
    }
}
