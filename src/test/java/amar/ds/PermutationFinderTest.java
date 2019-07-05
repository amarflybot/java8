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
        final Set<String> stringSet = PermutationFinder.permutationFinder("AB");
        assertEquals(2, stringSet.size());
        assertEquals(true, stringSet.contains("AB"));
        assertEquals(true, stringSet.contains("BA"));
    }

    public void testFor3Chars(){
        final Set<String> stringSet = permutationFinder("ABC");
        assertEquals(6, stringSet.size());
    }

    private Set<String> permutationFinder(final String str) {
        final Set<String> stringSet = new HashSet<>();
        if(str == null){
            return null;
        }
        else if(str.length()==0){
            stringSet.add("");
            return stringSet;
        }
        final char initial = str.charAt(0);
        final String rem = str.substring(1);
        final Set<String> words = permutationFinder(rem);

        for(final String word : words){
            final int length = word.length();
            for(int i = 0; i <= length; i++){
                stringSet.add(merge(word, initial, i));
            }
        }

        return stringSet;
    }

    private String merge(final String word, final char initial, final int i) {
        final String begin = word.substring(0,i);
        final String end = word.substring(i);
        return begin + initial + end;
    }

}
