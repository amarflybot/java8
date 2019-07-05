package amar.algorithm.list;

import amar.common.Person;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by amarendra on 02/09/17.
 */
public class TestDoublyLinkedList {

    @Test
    public void listTest() {

        final List<Person> personList = new DoublyLinkedList<>();
        personList.add(new Person(1L, "One"));
        personList.add(new Person(2L, "Two"));
        personList.add(new Person(3L, "Three"));
        personList.add(new Person(4L, "Four"));
        personList.add(new Person(1L, "One"));

        assertEquals(5, personList.size());

        personList.remove(0);
        personList.remove(new Person(1L, "One"));

        assertEquals(3, personList.size());

        System.out.println(personList);

        final boolean contains = personList.contains(new Person(4L, "Four"));

        //assertEquals(true, contains);


    }

    @Test
    public void listTest1(){

        final List<Person> personList = new DoublyLinkedList<>();
        personList.add(new Person(1L,"One"));
        personList.add(new Person(2L,"Two"));
        personList.add(new Person(3L,"Three"));

        final List<Person> personList2 = new DoublyLinkedList<>();
        personList2.add(new Person(4L,"Four"));
        personList2.add(new Person(5L,"Five"));
        personList2.add(new Person(6L,"Six"));

        
    }

}
