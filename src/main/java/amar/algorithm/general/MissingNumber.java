package amar.algorithm.general;

/**
 * Created by amarendra on 16/09/17.
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list.
 * One of the integers is missing in the list. Write an efficient code to find the missing integer.
 * Example:
 *  I/P    [1, 2, 4, ,6, 3, 7, 8]
 *  O/P    5
 */
public class MissingNumber {

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 6, 3, 7, 8};
        int total = sum(8);
        System.out.println("total -> "+ total);
        for (int i = 0; i < arr.length; i++) {
            total = total - arr[i];
        }
        System.out.println("Missing Number: "+ total);
    }

    private static int sum(final int n) {
        return n*(n+1)/2;
    }
}
