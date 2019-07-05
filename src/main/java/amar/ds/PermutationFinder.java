package amar.ds;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by amarendra on 16/02/16.
 */
public class PermutationFinder {

    private final static Logger logger = Logger.getLogger("PermutationFinder");

    public static Set<String> permutationFinder(final String str) {
        final Set<String> perm = new HashSet<>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        final char initial = str.charAt(0); // first character
        final String rem = str.substring(1); // Full string without first character
        final Set<String> words = permutationFinder(rem);
        words.stream().forEach(strNew -> {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(charInsert(strNew, initial, i));
            }
        });
        //logger.info("Perm size == "+perm.size());
        return perm;
    }

    public static String charInsert(final String str, final char c, final int j) {
        final String begin = str.substring(0, j);
        final String end = str.substring(j);
        final String string = begin + c + end;
        return string;
    }

    public static void main(final String[] args) {
        final String s = "ABC";
        final long startTime = new Date().getTime();
        logger.info("Started Permutation at " + new Date());
        logger.info(("Permutations for " + s + " are: " + permutationFinder(s)));
        final long endTime = new Date().getTime();
        logger.info(("Time taken by " + s + " is " + (endTime - startTime)));
    }
}
