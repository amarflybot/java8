package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by amarendra on 27/08/17.
 */
public class MapTest {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Stream.of("1,Amar,28","2,Vicky,26","3,Alka,27")
                .map(x -> x.split(","))
                .forEach(tuple -> personList.add(new Person(Long.parseLong(tuple[0]),tuple[1],Integer.parseInt(tuple[2]))));

        List<Integer> integerList = new ArrayList<>();
        personList.stream()
                .forEach(person -> integerList.add(person.getAge()));

        integerList.forEach(System.out::println);
        Optional<Integer> max = Collections.EMPTY_LIST.stream().max(Comparator.naturalOrder());
        System.out.println(max);
        Integer sum = integerList.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum -> "+ sum);

        String collected = personList.stream()
                .filter(person -> person.getAge() >26)
                .map(person -> person.getName())
                .collect(Collectors.joining(","));

        List<String> collectedAsList = personList.stream()
                .filter(person -> person.getAge() > 26)
                .map(person -> person.getName())
                .collect(Collectors.toList());

        System.out.println(collected);
        System.out.println(collectedAsList);

        Map<Integer, List<Person>> collect = personList.stream()
                .filter(person -> person.getAge() > 26)
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(collect);

        List<Person> collect1 = Stream.of(personList, personList, personList)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}

class Person{
    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Person(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}