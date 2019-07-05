package amar.algorithm.general;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by amarendra on 08/09/17.
 * <p>
 * Searching for 555555 from 1000000 elements
 * TreeSet Time Taken: 1705
 * ArrayList Time Taken: 2207
 * Priority Queue Time Taken: 2180
 * HashSet Time Taken: 3719
 * <p>
 * Searching for 5 from 1000000 elements
 * TreeSet Time Taken: 1670
 * ArrayList Time Taken: 2151
 * Priority Queue Time Taken: 2069
 * HashSet Time Taken: 3829
 * <p>
 * Searching for 999999 from 1000000 elements
 * TreeSet Time Taken: 1636
 * ArrayList Time Taken: 2076
 * Priority Queue Time Taken: 2131
 * HashSet Time Taken: 2895
 */
public class PriorityQueueTest {

    public static void main(final String[] args) {
        final Date start = new Date();
        //Queue<Person1> person1Queue = new PriorityQueue<>();
        //List<Person1> list = new ArrayList<>();
        final Set<Person1> person1s = new HashSet<>();
        for (int i = 0; i < 1000000; i++) {
            person1s.add(new Person1(i, String.valueOf(i)));
        }


        //boolean offer = person1Queue.offer(new Person1(555555, String.valueOf(555555)));
        final boolean contains = person1s.contains(new Person1(999999, String.valueOf(999999)));
        System.out.println(contains);
        final Date end = new Date();

        System.out.println("Time Taken: " + (end.getTime() - start.getTime()));
    }
}

class Person1 implements Comparable<Person1> {
    private Integer id;
    private String name;

    public Person1(final Integer id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Person1 person1 = (Person1) o;

        if (id != null ? !id.equals(person1.id) : person1.id != null) return false;
        return name != null ? name.equals(person1.name) : person1.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(final Person1 o) {
        return this.getId().compareTo(o.getId());
    }
}
