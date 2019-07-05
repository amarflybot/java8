package amar.algorithm.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Permutation {

    public static void main(final String[] args) {

        final String str = "I love my india";

        final Date date = new Date();
        final List<String> result =
                permutationList(Arrays.asList(str.split(" ")));
        final Date end = new Date();
        System.out.println(result.size());
        System.out.println("Time Taken -> " + (end.getTime() - date.getTime()));

    }

    private static List<String> permutationList(final List<String> asList) {

        final List<String> stringList = new ArrayList<>();

        if (asList.size() == 1) {
            //stringList.add("");
            return asList;
        }

        final String firstElement = asList.get(0);
        final List<String> restElement = asList.subList(1, asList.size());
        final List<String> ret = permutationList(restElement);

        ret.forEach(string -> {
            for (int i = 0; i <= ret.size(); i++) {
                final String str = generateStringToAdd(firstElement, string, i);
                if (str == null) {
                    break;
                }
                stringList.add(str);
                //System.out.println(str);
            }
        });

        return stringList;
    }

    private static String generateStringToAdd(final String firstElement, final String stringToAddto, final int position) {
        final String[] add = stringToAddto.split(" ");
        final String[] toReturn = Arrays.copyOf(add, add.length + 1);
        if (toReturn.length == position) {
            return null;
        }
        final String temp = toReturn[position] == null ? firstElement : toReturn[position];
        toReturn[position] = firstElement;
        toReturn[add.length] = temp;
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i] != null && toReturn[i].length() > 0) {
                builder.append(toReturn[i]).append(" ");
            }
        }
        return builder.toString();
    }

    private static List<String> permutation(final String str) {
        final List<String> strList = new ArrayList<>();
        if (str.length() == 0) {
            strList.add("");
            return strList;
        }

        final String first = str.substring(0, 1);
        final String rest = str.substring(1, str.length());
        List<String> words = new ArrayList<>();
        words = permutation(rest);

        words.forEach(string -> {
            for (int i = 0; i <= string.length(); i++) {
                strList.add(getStringComb(first, string, i));
            }
        });

        return strList;
    }

    private static String getStringComb(final String first, final String string, final int i) {
        final String firstPart = string.substring(0, i);
        final String secondPart = string.substring(i, string.length());
        return firstPart + first + secondPart;
    }


}
