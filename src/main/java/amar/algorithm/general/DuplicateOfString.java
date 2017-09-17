package amar.algorithm.general;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 15/09/17.
 * write a program to print duplicates in given string
 */
public class DuplicateOfString {

    public static void main(String[] args) {

        String str = "asddfgghjrettyiasdaaa";
        Map<Character, Integer> map = new HashMap<>();
        for (final char ch : str.toCharArray()) {
            if (map.containsKey(ch)){
                map.put(ch, (map.get(ch) + 1));
            } else {
                map.put(ch, 1);
            }
        }


        System.out.println(map);
    }
}
