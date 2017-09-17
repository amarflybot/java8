package amar.algorithm.general;

import com.sun.tools.javac.util.Assert;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by amarendra on 15/09/17.
 * Write a program to implement filtered Iterator which will take Iterator and condition as inputs.
 * If i call hasNext() it should return true if any object exists with matching condition ,
 * next should return the matching object.
 */
public class FilteredIteratorTest {

    public static void main(String[] args) {

        final List<Person> personList = Stream.of("1,Amar", "3,Vicky", "4,Papa", "4,Mom","2,Alka")
                .map(string -> string.split(","))
                .map(parameters -> new Person(Integer.valueOf(parameters[0]), parameters[1]))
                .collect(Collectors.toList());

        personList.add(new Manager(12,"Merlin"));
        personList.add(new Manager(13,"Deepesh"));

        Filter<Person> personFilter = new PersonCondition();
        Iterator<Person> personIterator = new FilteredIterator(personList.iterator(),personFilter);

        while (personIterator.hasNext()){
            System.out.println(personIterator.next());
        }

    }

}

class PersonCondition implements Filter<Person>{

    @Override
    public boolean matches(final Person person) {
        return Arrays.asList("Amar","Alka","Merlin").contains(person.getName());
    }
}

class Manager extends Person{

    public Manager(final Integer id, final String name) {
        super(id, name);
    }
}

class Person {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Person(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}

class FilteredIterator<T> implements Iterator<T>{

    private Iterator<? extends T> iterator;
    private Filter<T> filter;
    private boolean hasNext;
    private T nextElement;

    public FilteredIterator(final Iterator<? extends T> iterator, final Filter<T> filter) {
        Assert.checkNonNull(iterator);
        Assert.checkNonNull(filter);
        this.iterator = iterator;
        this.filter = filter;
        nextMatchingElement();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public T next() {
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        return nextMatchingElement();
    }

    private T nextMatchingElement() {
        T oldElement = nextElement;
        while (iterator.hasNext()) {
            T t = iterator.next();
            if (filter.matches(t)){
                nextElement = t;
                hasNext = true;
                return oldElement;
            }
        }
        hasNext = false;
        return oldElement;
    }
}

interface Filter<T> {
    boolean matches(T element);
}