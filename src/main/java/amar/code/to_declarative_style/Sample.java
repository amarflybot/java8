package amar.code.to_declarative_style;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);
    
    List<Integer> doubled = 
      values.stream()
            .map(e -> e * 2)
            .collect(toList());
            
    System.out.println(doubled);
  }
}
