package amar.collections;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by amarendra on 30/08/17.
 */
public class TestArrayVsLinkedList {

    public static void main(String[] args) {


        List<Person> personArrayList = new ArrayList<>();
        List<Person> personLinkedList = new LinkedList<>();

        Date startDate = new Date();
        for (int i = 0; i < 100000; i++) {
            final long id = Long.parseLong(Integer.valueOf(i).toString());
            personArrayList.add(new Person(id, "Name"+id));
        }
        System.out.println("personArrayList.size " + personArrayList.size());
        Date endDate = new Date();
        System.out.println("Time Taken to Add to Array List-> "+ (endDate.getTime()-startDate.getTime()));

        startDate = new Date();
        for (int i = 0; i < 100000; i++) {
            final Person person = personArrayList.get(i);
            //System.out.println(person);
        }
        endDate = new Date();
        System.out.println("Time Taken to get from Array List-> "+ (endDate.getTime()-startDate.getTime()));

        System.out.println("-----------------====================---------------------");

        startDate = new Date();
        for (int i = 0; i < 100000; i++) {
            final long id = Long.parseLong(Integer.valueOf(i).toString());
            personLinkedList.add(new Person(id, "Name"+id));
        }
        System.out.println("personLinkedList.size " + personArrayList.size());
        endDate = new Date();
        System.out.println("Time Taken to add into Linked List-> "+ (endDate.getTime()-startDate.getTime()));

        startDate = new Date();
        for (int i = 0; i < 100000; i++) {
            final Person person = personLinkedList.get(i);
            //System.out.println(person);
        }
        endDate = new Date();
        System.out.println("Time Taken to get from Linked List-> "+ (endDate.getTime()-startDate.getTime()));
    }
}
