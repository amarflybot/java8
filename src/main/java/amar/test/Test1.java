package amar.test;


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by amarendra on 01/09/17.
 */
public class Test1 {

    public static void main(String[] args) throws Exception {

        List<Person> personList = new LinkedList<>();

        personList.add(new Person("Amar", 12));
        personList.add(new Person("Vicky", 10));
        personList.add(new Person("Papa", 42));

        System.out.println(personList);

        Collections.sort(personList);

        System.out.println("Natural Order -> " + personList);

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(final Person o1, final Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println("Order by Name -> " + personList);
    }

}


class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    public Person(final String name, final Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(final Person o) {
        if (this.age > o.getAge()) {
            return 1;
        }
        if (this.age < o.getAge()) {
            return -1;
        }
        return 0;
    }
}
