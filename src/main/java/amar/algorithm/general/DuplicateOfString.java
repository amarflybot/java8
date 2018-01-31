package amar.algorithm.general;

import java.util.*;

/**
 * Created by amarendra on 15/09/17.
 * write a program to print duplicates in given string
 */
public class DuplicateOfString {

    public static void main(String[] args) {


        // Duplicate for whole
        String str = "asddfgghjrettyiasdaaa";
        Map<Character, Integer> map = new HashMap<>();
        for (final char ch : str.toCharArray()) {
            if (map.containsKey(ch)){
                map.put(ch, (map.get(ch) + 1));
            } else {
                map.put(ch, 1);
            }
        }


        System.out.println(" Duplicate for whole: "+ map);

        // Duplicate in Order
        Stack<Node> stack = new Stack<>();
        for (final char ch : str.toCharArray()) {
            if (!stack.isEmpty()) {
            final Node node = stack.peek();
            if (node != null && node.getCharacter().charValue() == ch) {
                final Node polledNode = stack.pop();
                Node nodeToBeOffered = polledNode.IncreaseOccurences();
                stack.push(nodeToBeOffered);
            } else {
                stack.push(new Node(ch));
            }
            } else {
                stack.push(new Node(ch));
            }
        }

        System.out.println(" Duplicate in Order: " + stack);
    }
}

class Node{
    private Character character;
    private Integer occurrence;

    public Node(final Character character) {
        this.character = character;
        this.occurrence = 1;
    }

    public Node(final Character character, final Integer occurrence) {
        this.character = character;
        this.occurrence = occurrence;
    }

    public Character getCharacter() {
        return character;
    }

    public Integer getOccurrence() {
        return occurrence;
    }

    public Node IncreaseOccurences() {
        this.occurrence++;
        return this;
    }

    @Override
    public String toString() {
        return character +"="+ occurrence;
    }
}
