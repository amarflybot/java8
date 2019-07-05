package amar.code.using_higher_order_functions;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Sample {
//  public static boolean isPrime(int number) {
//    if(number > 1) {
//      for(int i = 2; i < number; i++) {
//        if(number % i == 0)
//          return false;
//      }
//      return true;
//    }
//    return false;
//  }

    public static boolean isPrime(final int number) {
        final IntPredicate indexDividesNumber = i -> number % i == 0;

        return number > 1 &&
                IntStream.range(2, number).noneMatch(indexDividesNumber);
    }

    public static void main(final String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d is prime? %b\n", i, isPrime(i));
        }
    }
}

