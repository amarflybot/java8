package amar.designPattern.immutable;

import java.util.Date;

/**
 * Created by amarendra on 27/01/16.
 */
public class ImmutableTest {

    public static void main(String[] args) {
        Roll roll = new Roll(1);
        Person person = new Person(roll, new Date());
        System.out.println(person.getDate());
        System.out.println(person);
        roll.setInteger(2);
        person.getRoll().setInteger(2);
        person.getDate().setTime(new Date().getTime());
        System.out.println(person);
        System.out.println(person.getDate());
    }
}

final class Person{
    final private Roll roll;
    final private Date date;

    public Person(Roll roll, Date date) {
        this.roll = new Roll(roll.getInteger());
        this.date = date;
    }

    public Roll getRoll() {
        return new Roll(roll.getInteger());
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    @Override
    public String toString() {
        return "Person{" +
                "roll=" + roll +
                ", date=" + date +
                '}';
    }
}

class Roll{
    private Integer integer;

    public Roll(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "integer=" + integer +
                '}';
    }
}
