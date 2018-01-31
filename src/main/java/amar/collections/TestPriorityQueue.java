package amar.collections;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by amarendra on 23/10/17.
 */
public class TestPriorityQueue {

    public static void main(String[] args) {
        Queue<Element> queue = new PriorityQueue<>(Element.reverseComparator());
        queue.add(new Element(2));
        queue.add(new Element(1));

        System.out.println(queue);

        Cat c = new Cat();
        Animal b = (Animal) c;

        System.out.println(b);
    }
}

class Element implements Comparable<Element>{

    @Override
    public String toString() {
        return "Element{" +
                "integer=" + integer +
                '}';
    }

    private Integer integer;

    public Element(final Integer integer) {
        this.integer = integer;
    }

    @Override
    public int compareTo(final Element element) {
        return Objects.compare(this, element, new Comparator<Element>() {
            @Override
            public int compare(final Element o1, final Element o2) {
                return o1.integer.compareTo(o2.integer);
            }
        });
    }

    public static Comparator<Element> reverseComparator() {
        return (o1, o2) -> o2.integer.compareTo(o1.integer);
    }
}

class LivingBeing {
    public void move() throws ClassCastException{

    }
}

class Animal extends LivingBeing {
    @Override
    public void move() throws ArrayIndexOutOfBoundsException {
    }
}

class Cat extends Animal {
    @Override
    public void move() throws ArrayIndexOutOfBoundsException {

    }
}
