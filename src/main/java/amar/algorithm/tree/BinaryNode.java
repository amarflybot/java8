package amar.algorithm.tree;

/**
 * Created by amarendra on 03/09/17.
 */
class BinaryNode<T extends Comparable<T>> implements Comparable<BinaryNode<T>>{

    private T value;
    private BinaryNode<T> left;
    private BinaryNode<T> right;

    public BinaryNode(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public void setLeft(final BinaryNode<T> left) {
        this.left = left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setRight(final BinaryNode<T> right) {
        this.right = right;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final BinaryNode<?> that = (BinaryNode<?>) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }



    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BinaryNode{ "+ value.toString()+" }";
    }


    @Override
    public int compareTo(final BinaryNode<T> o) {
        return this.compareTo(o);
    }
}
