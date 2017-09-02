package amar.test;


import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by amarendra on 01/09/17.
 */
public class Test1 {

    public static void main(String[] args) throws Exception {

        List<Person> personList = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            personList.add(new Person(String.valueOf(i)));
        }

        Date date = new Date();

        for (int i = 0; i < 1000000; i++) {
            personList.get(999999);
        }

        Date endDate = new Date();

        System.out.println("Time taken : " + (endDate.getTime() - date.getTime()));

    }

}


class Person{

    private String name;

    public Person(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}