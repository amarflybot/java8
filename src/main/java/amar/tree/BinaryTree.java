package amar.tree;

/**
 * Example for BinaryTree in java
 * Created by amarendra on 05/01/16.
 */
public class BinaryTree {

    Node root;

    public static void main(final String[] args) {

        final BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(50, "Boss50");
        binaryTree.addNode(45, "Boss45");
        binaryTree.addNode(40, "Boss40");
        binaryTree.addNode(58, "Boss58");
        binaryTree.addNode(59, "Boss59");
        binaryTree.addNode(23, "Boss23");
        binaryTree.addNode(47, "Boss47");
        binaryTree.addNode(42, "Boss42");
        binaryTree.addNode(56, "Boss56");


        System.out.println("====================inOrderTraverseTree======================");
        binaryTree.inOrderTraverseTree(binaryTree.root);
        System.out.println("====================preOrderTraverseTree======================");
        binaryTree.preOrderTraverseTree(binaryTree.root);
        System.out.println("====================postOrderTraverseTree======================");
        binaryTree.postOrderTraverseTree(binaryTree.root);
        System.out.println("====================findNode======================");
        System.out.println(binaryTree.findNode(59));

    }

    public void addNode(final int key, final String name) {

        final Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(final Node focusNode) {

        if (focusNode != null) {
            inOrderTraverseTree(focusNode.left);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.right);
        }
    }


    public void preOrderTraverseTree(final Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.left);
            preOrderTraverseTree(focusNode.right);
        }
    }

    public void postOrderTraverseTree(final Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);
            System.out.println(focusNode);
        }
    }

    public Node findNode(final int key) {
        Node focusNode = root;

        while (focusNode.key != key) {

            if (key < focusNode.key) {
                focusNode = focusNode.left;
            } else {
                focusNode = focusNode.right;
            }
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }
}

class Node {
    int key;
    String name;

    Node left, right;

    public Node(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Key -> " + key + " name-> " + name;
    }
}
