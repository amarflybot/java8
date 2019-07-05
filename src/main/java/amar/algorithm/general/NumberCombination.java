package amar.algorithm.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by amarendrakumar on 03/06/17.
 */
public class NumberCombination {

    public static void main(final String[] args) {
        final List<List<String>> lists = combinationFinder("2101");
        System.out.println(lists);
    }

    private static List<List<String>> combinationFinder(final String str) {
        if (str.isEmpty()) {
            return Collections.singletonList(Collections.emptyList());
        }
        final List<List<String>> result = new ArrayList<>();
        // can we split off 1 char from the start? requires just non-zero
        if (str.charAt(0) != '0') {
            final String firstChar = str.substring(0, 1);
            if (!Character.isDigit(firstChar.charAt(0))) {
                throw new IllegalArgumentException("Not a digit: " + firstChar);
            }
            final List<List<String>> combinationsOfRemainingStr
                    = combinationFinder(str.substring(1));
            addAllCombos(result, firstChar, combinationsOfRemainingStr);
        }
        // can we split off 2 chars?
        if (str.length() >= 2) {
            final String firstSubstring = str.substring(0, 2);
            final int firstNumber = Integer.parseInt(firstSubstring);
            if (firstNumber >= 1 && firstNumber <= 26) { // OK
                final List<List<String>> combinationsOfRemainingStr
                        = combinationFinder(str.substring(2));
                addAllCombos(result, firstSubstring, combinationsOfRemainingStr);
            }
        }
        return result;
    }

    /**
     * adds to result all lists made up of firstElement followed by a list from remainingElements
     */
    private static void addAllCombos(final List<List<String>> result,
                                     final String firstElement, final List<List<String>> remainingElements) {
        for (final List<String> remCombo : remainingElements) {
            final List<String> totalCombo = new ArrayList<>(1 + remCombo.size());
            totalCombo.add(firstElement);
            totalCombo.addAll(remCombo);
            result.add(totalCombo);
        }
    }
}
