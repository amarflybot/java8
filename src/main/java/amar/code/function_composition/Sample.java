package amar.code.function_composition;

import java.util.*;
import java.util.stream.*;

public class Sample {  
  static final int MAX = 1000;
  
  public static int computeSumOfDoubleOf1000EvenFrom(int starting) {
    int count = 0;
    int total = 0;
    int number = starting;
    
    while(count < MAX) {
      if(number % 2 == 0) {
        total += number * 2;
        count++;
      }
      number = number + 1;
    }
    
    return total;
  }
  
  public static int computeSumOfDoubleOf1000EvenFromFunctional(int starting) {
    return Stream.iterate(starting, e -> e + 1)
                 .filter(e -> e % 2 == 0)
                 .mapToInt(e -> e * 2)
                 .limit(MAX)
                 .sum();
  }
  
  public static void main(String[] args) {
    //Find the sum of double of first 1000 even numbers starting with a given number.
    
    int starting = 33;
    
    System.out.println(computeSumOfDoubleOf1000EvenFrom(starting));
    
    System.out.println(computeSumOfDoubleOf1000EvenFromFunctional(starting));
  }
}
