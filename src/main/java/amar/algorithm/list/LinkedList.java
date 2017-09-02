package amar.algorithm.list;

import java.util.AbstractList;

/**
 * Created by amarendra on 02/09/17.
 */
public class LinkedList<T> extends AbstractList<T>{

    private Node<T> head;

    private Node<T> tail;
    private int count;



    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void addFirst(T value) {
        addFirst(new Node<>(value));
    }

    public void addFirst(Node<T> value) {
        Node<T> temp = head;
        head = value;
        head.setNext(temp);
        count++;
        if (count == 1) {
            tail = head;
        }
    }

    public void addLast(T value) {
        addLast(new Node<>(value));
    }

    public void addLast(Node<T> value) {
        if (count == 0) {
            head = tail;
        }
        else {
            tail.setNext(value);
        }
        tail = value;
        count++;
    }

    public T removeFirst(){
        T temp = head.getVal();
        if (count != 0) {
            head = head.getNext();
            count--;
            if (count == 0){
                tail = null;
            }
        }
        return temp;
    }

    public T removeLast(){
        T temp = tail.getVal();
        if (count != 0) {
            if (count == 1) {
                head = null;
                tail = null;
            }
            else {

                Node<T> currentNode = head;
                while (currentNode.getNext() != tail){
                    currentNode = currentNode.getNext();
                }
                // This is one node before tail node.
                currentNode.setNext(null);
                tail = currentNode;
                count--;
            }
        }
        return temp;
    }

    @Override
    public T get(final int index) {
        if (index > count && index < 0) {
            throw new IllegalArgumentException("Wrong parameter, try between 0 and "+ count);
        }
        Node<T> currentNode = head;
        int i = 0;
        while (i <= index){
            if (i == index) {
                return currentNode.getVal();
            }
            i ++;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean add(final T t) {
        if (count == 0) {
            addFirst(t);
        } else {
            addLast(t);
        }
        return true;
    }


    @Override
    public T remove(final int index) {
        if (count != 0) {
            return removeFirst();
        }
        return null;
    }

    @Override
    public boolean contains(final Object o) {
        return super.contains(o);
    }
}

class Node<T> {
    private T val;
    private Node<T> next;

    public Node(final T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(final Node<T> next) {
        this.next = next;
    }
}
