package amar.algorithm.tree;

/**
 * Created by amarendra on 02/09/17.
 */
public class BinaryTreeTest {

    public static void main(String[] args) {

        BinaryTree<Integer> integerBinaryNode = new BinaryTree<>();
        integerBinaryNode.add(4);
        integerBinaryNode.add(2);
        integerBinaryNode.add(1);
        integerBinaryNode.add(3);
        integerBinaryNode.add(6);
        integerBinaryNode.add(5);
        integerBinaryNode.add(7);

        System.out.println("===========preOrderTraversal=============");
        integerBinaryNode.preOrderTraversal();
        System.out.println("===========inOrderTraversal=============");
        integerBinaryNode.inOrderTraversal();
        System.out.println("===========postOrderTraversal=============");
        integerBinaryNode.postOrderTraversal();
        System.out.println("========================");

        BinaryNode<Integer> findWithParent = integerBinaryNode.findWithParent(4);
        System.out.println(findWithParent);



    }
}

