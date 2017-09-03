package amar.algorithm.tree;

/**
 * Created by amarendra on 02/09/17.
 */
public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryNode<Integer> integerBinaryNode = new BinaryNode<>(4);
        integerBinaryNode.add(2);
        integerBinaryNode.add(1);
        integerBinaryNode.add(3);
        integerBinaryNode.add(6);
        integerBinaryNode.add(5);
        integerBinaryNode.add(7);

        /*System.out.println("========================");
        preOrderTraversal(integerBinaryNode);
        System.out.println("========================");
        inOrderTraversal(integerBinaryNode);
        System.out.println("========================");
        postOrderTraversal(integerBinaryNode);
        System.out.println("========================");*/

        boolean contains = integerBinaryNode.contains(9);
        System.out.println(contains);
    }

    public static <T extends Comparable<T>> void postOrderTraversal(BinaryNode<T> node){
        if (node == null) {
            return;
        }

        postOrderTraversal(node.getLeft());

        postOrderTraversal(node.getRight());

        process(node);
    }

    public static <T extends Comparable<T>> void inOrderTraversal(BinaryNode<T> node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeft());

        process(node);

        inOrderTraversal(node.getRight());
    }

    public static <T extends Comparable<T>> void preOrderTraversal(BinaryNode<T> node){
        if (node == null) {
            return;
        }

        process(node);

        preOrderTraversal(node.getLeft());

        preOrderTraversal(node.getRight());
    }

    private static <T extends Comparable<T>> void process(final BinaryNode<T> node) {
        System.out.println("Node -> " + node);
    }
}

class BinaryNode<T extends Comparable<T>> {

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

    public void add(final T val){
        add(this, new BinaryNode<>(val));
    }

    public void add(final BinaryNode<T> node){
        add(this, node);
    }

    private void add(final BinaryNode<T> binaryNode, final BinaryNode<T> toAdd){
        if (binaryNode.getValue().compareTo(toAdd.getValue()) > 0){

            if (binaryNode.getLeft() == null) {
                binaryNode.setLeft(toAdd);
            } else {
                add(binaryNode.getLeft(),toAdd);
            }

        } else {
            if (binaryNode.getRight() == null){
                binaryNode.setRight(toAdd);
            } else {
                add(binaryNode.getRight(), toAdd);
            }
        }
    }

    public boolean contains(T val) {
        return contains(this, val);
    }

    private boolean contains(BinaryNode<T> binaryNode, T val){
        boolean ret;

        if (binaryNode == null) {
            return false;
        }

        if (binaryNode.getValue().equals(val)){
            return true;
        }

        if (binaryNode.getValue().compareTo(val) > 0){
            ret = contains(binaryNode.getLeft(), val);
        } else {
            ret = contains(binaryNode.getRight(), val);
        }

        return ret;
    }

    public boolean remove(T val){



        return false;
    }

    @Override
    public String toString() {
        return "BinaryNode{ "+ value.toString()+" }";
    }
}
