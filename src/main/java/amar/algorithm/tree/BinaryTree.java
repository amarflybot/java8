package amar.algorithm.tree;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by amarendra on 03/09/17.
 */
public class BinaryTree<T extends Comparable<T>> implements Collection<T> {

    private int count;

    private BinaryNode<T> head;

    public BinaryTree() {
    }

    public BinaryTree(final T val) {
        this.head = new BinaryNode<>(val);
        count++;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(final Object o) {
        return this.contains((T) o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(final T1[] a) {
        return null;
    }


    @Override
    public boolean remove(final Object o) {
        return remove((T) o);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        final Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            final Object next = iterator.next();
            return contains(next);
        }

        return false;
    }

    @Override
    public boolean addAll(final Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(final Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(final Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final BinaryTree<?> that = (BinaryTree<?>) o;

        return head != null ? head.equals(that.head) : that.head == null;
    }

    @Override
    public int hashCode() {
        return head != null ? head.hashCode() : 0;
    }

    @Override
    public boolean add(final T val) {
        return add(this.head, new BinaryNode<>(val));
    }

    public boolean add(final BinaryNode<T> node) {
        return add(this.head, node);
    }

    private boolean add(final BinaryNode<T> binaryNode, final BinaryNode<T> toAdd) {

        if (binaryNode == null) {
            //This is first node and hence the head node.
            head = toAdd;
            return true;
        }

        if (binaryNode.getValue().compareTo(toAdd.getValue()) > 0) {

            if (binaryNode.getLeft() == null) {
                binaryNode.setLeft(toAdd);
                count++;
                return true;
            } else {
                add(binaryNode.getLeft(), toAdd);
            }

        } else {
            if (binaryNode.getRight() == null) {
                binaryNode.setRight(toAdd);
                count++;
                return true;
            } else {
                add(binaryNode.getRight(), toAdd);
            }
        }
        return false;
    }

    public boolean contains(final T val) {
        return find(this.head, val) != null;
    }

    private BinaryNode<T> find(final BinaryNode<T> binaryNode, final T val) {
        final BinaryNode<T> ret;

        if (binaryNode == null) {
            return null;
        }

        if (binaryNode.getValue().equals(val)) {
            return binaryNode;
        }

        if (binaryNode.getValue().compareTo(val) > 0) {
            ret = find(binaryNode.getLeft(), val);
        } else {
            ret = find(binaryNode.getRight(), val);
        }

        return ret;
    }

    public BinaryNode<T> findWithParent(final T val) {
        return findWithParent(this.head, val, this.head);
    }

    private BinaryNode<T> findWithParent(final BinaryNode<T> binaryNode, final T val, final BinaryNode<T> parent) {
        final BinaryNode<T> ret;

        if (binaryNode == null) {
            return null;
        }

        if (binaryNode.getValue().equals(val)) {
            return parent;
        }

        if (binaryNode.getValue().compareTo(val) > 0) {
            ret = findWithParent(binaryNode.getLeft(), val, binaryNode);
        } else {
            ret = findWithParent(binaryNode.getRight(), val, binaryNode);
        }

        return ret;
    }

    public boolean remove(final T val) {

        final BinaryNode<T> current = find(this.head, val);

        final BinaryNode<T> parent = findWithParent(val);

        if (current == null) {
            // Nothing was found, so return false.
            return false;
        }

        count--;

        // Case 1: If the current node has no right child, then the current's left replaces the current.

        if (current.getRight() == null) {

            if (parent == null) {
                head = current.getLeft();
            } else {
                final int compareTo = parent.compareTo(current);

                if (compareTo > 0) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        }
        // Case 2: If the current node has no left child, then current's right replaces the current.
        else if (current.getLeft() == null) {

            if (parent == null) {
                head = current.getRight();
            } else {
                final int compareTo = parent.compareTo(current);
                if (compareTo > 0) {
                    parent.setLeft(current.getRight());
                } else {
                    parent.setRight(current.getRight());
                }
            }

        }
        // if the current's right child has a left child, replace the current with the current's right
        // child's left-most child.
        else {

            // find current's right's left.
            BinaryNode<T> leftMost = current.getRight().getLeft();
            BinaryNode<T> leftMostParent = current.getRight();

            // find the right's left most child.
            while (leftMost.getLeft() != null) {
                leftMostParent = leftMost;
                leftMost = leftMost.getLeft();
            }

            // the parent's left subtree becomes the leftmost's right subtree.
            leftMostParent.setLeft(leftMost.getRight());

            // assign leftmost's left and leftmost's right to current's left and current's right simultaneously.
            leftMost.setLeft(current.getLeft());
            leftMost.setRight(current.getRight());

            if (parent == null) {
                head = leftMost;
            } else {
                final int compareTo = parent.compareTo(current);
                if (compareTo > 0) {
                    parent.setLeft(leftMost);
                } else {
                    parent.setRight(leftMost);
                }
            }

        }

        return true;
    }

    public void postOrderTraversal() {
        postOrderTraversal(head);
    }

    public void inOrderTraversal() {
        inOrderTraversal(head);
    }

    public void preOrderTraversal() {
        preOrderTraversal(head);
    }

    private <T extends Comparable<T>> void postOrderTraversal(final BinaryNode<T> node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.getLeft());

        postOrderTraversal(node.getRight());

        process(node);
    }

    private <T extends Comparable<T>> void inOrderTraversal(final BinaryNode<T> node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeft());

        process(node);

        inOrderTraversal(node.getRight());
    }

    private <T extends Comparable<T>> void preOrderTraversal(final BinaryNode<T> node) {
        if (node == null) {
            return;
        }

        process(node);

        preOrderTraversal(node.getLeft());

        preOrderTraversal(node.getRight());
    }

    private <T extends Comparable<T>> void process(final BinaryNode<T> node) {
        System.out.println("Node -> " + node);
    }
}
