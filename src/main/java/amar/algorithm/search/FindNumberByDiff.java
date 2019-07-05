package amar.algorithm.search;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 12/09/17.
 */
public class FindNumberByDiff {

    public static void main(String[] args) {

        int[] array = {1, 2, 5, 6};

        int k = 1;
        final int count = findCount(array, k);
        System.out.println(count);
    }

    public static int findCount(final int[] array, final int k) {
        int count = 0;

        // Get all elements in hashmap as Key and value as true, this can also avoid duplicates.
        Map<Integer, Boolean> integerBooleanMap = new HashMap<>();
        for (final int anArray : array) {
            integerBooleanMap.put(anArray, true);
        }

        for (final int val : array) {
            if ((val - k) >= 0 &&
                    integerBooleanMap.get(val - k) != null &&
                    integerBooleanMap.get(val - k)) {
                count++;
            }
            if (val + k < Integer.MAX_VALUE &&
                    integerBooleanMap.get(val + k) != null &&
                    integerBooleanMap.get(val + k)) {
                count++;
            }
            integerBooleanMap.put(val, false);
        }
        return count;
    }
}
