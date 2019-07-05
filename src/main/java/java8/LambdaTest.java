package java8;

import java.io.FileFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by amarendra on 26/08/17.
 */
public class LambdaTest {

    public static void main(String[] args) {

        FileFilter fileFilter = pathname -> pathname.getName().endsWith(".java");
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("i -> " + i);
            }
        });

        List<String> list = Arrays.asList("Vicky", "Amar", "Alka", "Aammen");
        List<Person> personList = list.stream()
                .map(name -> new Person(Long.parseLong(String.valueOf(name.length())), name, name.length() + 10))
                .collect(Collectors.toList());

        System.out.println("PersonList -> " + personList);

        Collections.sort(list, Comparator.naturalOrder());

        Map<String, Person> personMap = personList.stream()
                .collect(Collectors.toMap(person -> person.getName(), person -> person));

        System.out.println("PersonMap -> " + personMap);

        final List<String> keys = personMap.keySet().stream().collect(Collectors.toList());

        System.out.println("Keys -> " + keys);

        final List<Person> values = personMap.keySet().stream().map(key -> personMap.get(key))
                .collect(Collectors.toList());

        System.out.println("Values -> " + values);

        Consumer<String> s1 = System.out::println;

        list.forEach(s1);

        Map<Person, String> hashMap = new HashMap<>();

        Person person = new Person(1L, "Amar", 28);
        hashMap.put(person, "String1");
        System.out.println(hashMap.get(person));
    }
}
