package amar.ds;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amarendra on 07/08/16.
 */
public class PermutationFinderTest extends TestCase{

    PermutationFinder permutationFinder = new PermutationFinder();

    public void testFor2Chars(){
        Set<String> stringSet = permutationFinder.permutationFinder("AB");
        assertEquals(2, stringSet.size());
        assertEquals(true, stringSet.contains("AB"));
        assertEquals(true, stringSet.contains("BA"));
    }

    public void testFor3Chars(){
        Set<String> stringSet = permutationFinder("ABC");
        assertEquals(6, stringSet.size());
    }

    private Set<String> permutationFinder(String str) {
        Set<String> stringSet = new HashSet<>();
        if(str == null){
            return null;
        }
        else if(str.length()==0){
            stringSet.add("");
            return stringSet;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);

        for(String word : words){
            int length = word.length();
            for(int i = 0; i <= length; i++){
                stringSet.add(merge(word, initial, i));
            }
        }

        return stringSet;
    }

    private String merge(String word, char initial, int i) {
        String begin = word.substring(0,i);
        String end = word.substring(i);
        return begin + initial + end;
    }

    public void testForFindPerm(){
        Set<String> perm = permutationFinder.findPerm("ABC");
        assertEquals(6, perm.size());
    }

}
