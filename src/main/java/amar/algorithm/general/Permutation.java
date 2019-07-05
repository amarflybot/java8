package amar.algorithm.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {

        String str = "I love Alka and Alka loves me India";

        Date date = new Date();
        List<String> result =
                permutationList(Arrays.asList(str.split(" ")));
        Date end = new Date();
        System.out.println(result.size());
        System.out.println("Time Taken -> " + (end.getTime() - date.getTime()));

    }

    private static List<String> permutationList(List<String> asList) {

        List<String> stringList = new ArrayList<>();

        if (asList.size() == 1) {
            //stringList.add("");
            return asList;
        }

        String firstElement = asList.get(0);
        List<String> restElement = asList.subList(1, asList.size());
        List<String> ret = permutationList(restElement);

        ret.forEach(string -> {
            for (int i = 0; i <= ret.size(); i++) {
                String str = generateStringToAdd(firstElement, string, i);
                if (str == null) {
                    break;
                }
                stringList.add(str);
                //System.out.println(str);
            }
        });

        return stringList;
    }

    private static String generateStringToAdd(String firstElement, String stringToAddto, int position) {
        String[] add = stringToAddto.split(" ");
        String[] toReturn = Arrays.copyOf(add, add.length + 1);
        if (toReturn.length == position) {
            return null;
        }
        String temp = toReturn[position] == null ? firstElement : toReturn[position];
        toReturn[position] = firstElement;
        toReturn[add.length] = temp;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < toReturn.length; i++) {
            if (toReturn[i] != null && toReturn[i].length() > 0) {
                builder.append(toReturn[i]).append(" ");
            }
        }
        return builder.toString();
    }

    private static List<String> permutation(String str) {
        List<String> strList = new ArrayList<>();
        if (str.length() == 0) {
            strList.add("");
            return strList;
        }

        String first = str.substring(0, 1);
        String rest = str.substring(1, str.length());
        List<String> words = new ArrayList<>();
        words = permutation(rest);

        words.forEach(string -> {
            for (int i = 0; i <= string.length(); i++) {
                strList.add(getStringComb(first, string, i));
            }
        });

        return strList;
    }

    private static String getStringComb(String first, String string, int i) {
        String firstPart = string.substring(0, i);
        String secondPart = string.substring(i, string.length());
        return firstPart + first + secondPart;
    }


}
