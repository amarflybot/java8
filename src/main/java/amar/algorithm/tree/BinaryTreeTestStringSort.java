package amar.algorithm.tree;

import java.util.Scanner;

/**
 * Created by amarendra on 03/09/17.
 */
public class BinaryTreeTestStringSort {

    public final static String QUIT = "quit";

    public static void main(String[] args) {

        BinaryTree<String> strings = new BinaryTree<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = "";
            input = scanner.next();
            if (!QUIT.equals(input)) {
                strings.add(input);
            } else {
                strings.inOrderTraversal();
            }
        }
    }
}
