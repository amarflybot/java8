package amar.code.lazy_evaluations;

import java.util.*;

public class Sample {  
  public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
    
    //Compute the double of first even number greater than 3.
    
    //imperative - this takes a total of 8 computations for the given example.
    int result = 0;
    for(int e : values) {
      if(isGreaterThan3(e) && isEven(e)) {
        result = doubleIt(e);
        break;
      }
    }
    System.out.println(result);
    
    //functional - though it appears expensive, this also takes only 8 computations for the given example.
    System.out.println(
      values.stream()
            .filter(Sample::isGreaterThan3)
            .filter(Sample::isEven)
            .map(Sample::doubleIt)
            .findFirst()
            .get());
            
    //To see the actual computations that took place for both versions, uncomment the three println below.
  }
  
  public static boolean isGreaterThan3(int number) {
    //System.out.println("isGreaterThan3 called for " + number);
    return number > 3;
  }

  public static boolean isEven(int number) {
    //System.out.println("isEven called for " + number);
    return number % 2 == 0;
  }

  public static int doubleIt(int number) {
    //System.out.println("doubleIt called for " + number);
    return number * 2;
  }
}
