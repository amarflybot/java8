package amar.algorithm.str;

import junit.framework.TestCase;

/**
 * Created by kumarao on 06-08-2016.
 */
public class StringHelperTest extends TestCase {

    public void testFor2WordsSwap(){
        final StringHelper stringHelper = new StringHelper();
        final String reversed = stringHelper.reverseLast2Chars("AB");
        assertEquals("BA", reversed);



    }

    public void testForAllWordsSwap(){
        final StringHelper stringHelper = new StringHelper();
        final String reversed = stringHelper.reverseLast2Chars("ANIL");
        assertEquals("ANLI", reversed);

    }

    public void testString(){
        System.out.println(Math.toIntExact((long) (Math.random() * 100)));
        final String str = "A".substring(0,0);
        System.out.println(str);
    }
}
