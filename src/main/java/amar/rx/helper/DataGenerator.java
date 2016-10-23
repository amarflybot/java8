package amar.rx.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {

    public static List<Integer> generateArrayList() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        return integerList;
    }

    public static List<Integer> generateBigIntegerList() {

        return IntStream.range(0, 199).boxed().collect(Collectors.toList());
    }

    public static List<String> generateGreekAlphabet() {

        List<String> strings = new ArrayList<>();
        strings.add("alpha");
        strings.add("beta");
        strings.add("gamma");
        strings.add("delta");
        strings.add("eta");
        strings.add("theta");
        strings.add("iota");
        strings.add("kappa");
        strings.add("lambda");
        strings.add("mu");
        strings.add("omega");
        strings.add("nu");
        strings.add("rho");
        strings.add("tau");

        return strings;
    }


    public static List<String> generateScrambleAndDuppedGreekAlphabet() {

        List<String> strings = new ArrayList<>();

        strings.addAll(generateGreekAlphabet());
        strings.addAll(generateGreekAlphabet());
        strings.addAll(generateGreekAlphabet());
        strings.addAll(generateGreekAlphabet());

        Collections.shuffle(strings);

        return strings;
    }

    public static List<Integer> generatorFibonacciList(int num) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(0);
        integerList.add(1);
        for(int i=2; i < num; i++){
            integerList.add(integerList.get(i-1) + integerList.get(i-2));
        }
        return integerList;
    }

    public static List<String> generateEnglishAlphabet() {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        strings.add("d");
        strings.add("q");
        strings.add("w");
        strings.add("e");
        strings.add("r");
        strings.add("t");
        strings.add("y");
        strings.add("u");
        strings.add("h");
        strings.add("g");
        strings.add("f");

        return strings;
    }
}