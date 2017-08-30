package amar.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 30/08/17.
 */
public class TypeSafeExample {

    public static void main(String[] args) {

        Concatanate<Person> personConcatanate = new Concatanate<>(new Person(1L, "One"), 1L);
        final Person person = personConcatanate.get();
        final Long id = personConcatanate.getId();
        System.out.println("Person -> "+ person);
        System.out.println("Id -> "+ id);
        personConcatanate.addToMap(2L, new Person(2L, "Two"));
        personConcatanate.addToMap(3L, new Person(3L, "Three"));

        final Person byId = personConcatanate.getById(3L);
        System.out.println(byId);
    }

}

class Concatanate<T> {

    private T t;
    private Long id;
    private Map<Long, T> map;

    public Concatanate(final T t, final Long id) {
        this.t = t;
        this.id = id;
        this.map = new HashMap<>();
        this.map.put(id, t);
    }

    public T getById(Long id){
        return map.get(id);
    }

    public void addToMap(Long id, T t){
        map.put(id, t);
    }

    public T get() {
        return t;
    }

    public Long getId() {
        return id;
    }
}

class Person {
    private Long id;
    private String name;

    public Person(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
