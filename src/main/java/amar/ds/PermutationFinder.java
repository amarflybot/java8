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
    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<>();
        //Handling error scenarios
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0); // first character
        String rem = str.substring(1); // Full string without first character
        Set<String> words = permutationFinder(rem);
        words.stream().forEach(strNew -> {
            for (int i = 0;i<=strNew.length();i++){
                perm.add(charInsert(strNew, initial, i));
            }
        });
        //logger.info("Perm size == "+perm.size());
        return perm;
    }

    public static String charInsert(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        String string = begin + c + end;
        return string;
    }

    public static void main(String[] args) {
        String s = "ABC";
        long startTime = new Date().getTime();
        logger.info("Started Permutation at "+ new Date());
        logger.info(("Permutations for " + s + " are: " + permutationFinder(s)));
        long endTime = new Date().getTime();
        logger.info(("Time taken by " + s+ " is " + (endTime - startTime)));
    }
}
