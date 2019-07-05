package amar.algorithm.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by amarendra on 31/07/16.
 */
public class Solution {

    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);

        int _coins_size = 0;
        _coins_size = Integer.parseInt(in.nextLine().trim());
        final long[] _coins = new long[_coins_size];
        long _coins_item;
        for (int _coins_i = 0; _coins_i < _coins_size; _coins_i++) {
            _coins_item = Long.parseLong(in.nextLine().trim());
            _coins[_coins_i] = _coins_item;
        }

        arrangeCoins(_coins);
    }

    private static void arrangeCoins(final long[] coins) {
        final java.util.stream.LongStream stream = Arrays.stream(coins);
        stream.parallel().forEachOrdered(coined -> internalLoop(coined, 1, false));

    }

    private static void internalLoop(final long coin, int no, boolean out) {
        for (long i = 1; i <= coin; i++) {
            for (long j = 1; j <= i; j++) {
                final int check = no++;
                if ((check == coin) && (i != j)) {
                    System.out.println(i - 1);
                    out = true;
                    break;
                } else if ((check == coin) && (i == j)) {
                    System.out.println(i);
                    out = true;
                    break;
                }
            }
            if (out) {
                break;
            }
        }
    }
}
