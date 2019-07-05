package amar.algorithm.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amarendra on 03/09/17.
 * <p>
 * Boyer-Moore-Horspool Search Algo
 */
public class BMHStringSearchAlgo implements StringSearchAlgo {

    Map<Character, Integer> bad_match = new HashMap<>();

    @Override
    public List<SearchMatch> search(final String toFind, final String search) {
        generateBadMatch(search);
        final int toFindLength = toFind.length();
        final int searchLength = search.length();
        int rounds = 0;
        final List<SearchMatch> matchList = new ArrayList<>();
        for (int i = searchLength - 1; i < toFindLength; i++) {
            int k = 0;
            for (int j = searchLength - 1; j >= 0; j--) {
                rounds++;
                if (toFind.charAt(i) != search.charAt(j)) {
                    i = getAndShift(toFind, i, k);
                    break;
                } else {
                    k++;
                    i--;
                    if (j == 0) {
                        // complete match
                        final SearchMatch searchMatch = new SearchMatchImpl(i + 1, searchLength);
                        matchList.add(searchMatch);
                        if (i < 0) {
                            i = toFindLength;
                            break;
                        }
                        i = getAndShift(toFind, i, k);
                    }
                }
            }
        }
        System.out.println("Total rounds -> " + rounds);
        return matchList;
    }

    public int getAndShift(final String toFind, int i, final int k) {
        final Integer integer = bad_match.get(toFind.charAt(i));
        final int numberToShift = integer == null ? bad_match.get('?') : integer;
        i = i + numberToShift - 1 + k;
        return i;
    }

    private void generateBadMatch(final String search) {

        final int length = search.length();
        if (length > 0) {
            bad_match.put('?', length);
            for (int i = 0; i < length - 1; i++) {
                final int distance = length - i - 1;
                bad_match.put(search.charAt(i), distance);
            }

        }

    }
}
