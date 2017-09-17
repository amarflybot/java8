package amar.collections;

import java.util.*;

import static java.util.Comparator.*;
import static java.util.Comparator.comparing;

/**
 * Created by amarendra on 28/08/17.
 */
public class Test1 {

    public static void main(String[] args) {



        Map<Person, Long> personMap = new IdentityHashMap<>();
        List<Person> personSet = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final Long key = Long.valueOf(Integer.valueOf(i).toString());
            final Person person = new Person(key, new StringJoiner(":", "Name", String.valueOf(10L - key)).toString());
            personMap.put(person, key);
            personSet.add(person);
        }

        Collections.sort(personSet, Person.BY_KEY.reversed());
        System.out.println(personSet);



    }
}

enum People{
    AMAR,
    ALKA,
    VICKY,
    DEEPAK,
    OLA
}

class Person implements Comparable<Person>{
    private Long id;
    private String name;

    public final static Comparator<Person> BY_NAME = comparing(Person::getName);
    public final static Comparator<Person> BY_KEY = comparing(Person::getId);

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Person person = (Person) o;

        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(final Person o) {
        return this.id.compareTo(o.getId());
    }
}
