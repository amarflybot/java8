package amar.code.from_imperative_style;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> doubled = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            doubled.add(values.get(i) * 2);
        }
        System.out.println(doubled);
    }
}
