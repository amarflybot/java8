package amar.tree;

/**
 * Created by amarendra on 05/01/16.
 */
public class BinaryTree {

    Node root;

    public void addNode(int key, String name){

        Node newNode = new Node(key, name);

        if(root == null){
            root = newNode;
        }
        else {
            Node focusNode = root;
            Node parent;
            while (true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        parent.left = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverseTree(Node focusNode){

        if(focusNode != null){
            inOrderTraverseTree(focusNode.left);

            System.out.println(focusNode);

            inOrderTraverseTree(focusNode.right);
        }
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(50, "Boss50");
        binaryTree.addNode(45, "Boss45");
        binaryTree.addNode(40, "Boss40");
        binaryTree.addNode(58, "Boss58");
        binaryTree.addNode(59, "Boss59");
        binaryTree.addNode(23, "Boss23");
        binaryTree.inOrderTraverseTree(binaryTree.root);

    }
}

class Node {
    int key;
    String name;

    Node left,right;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Key -> "+ key+ " name-> "+name;
    }
}
