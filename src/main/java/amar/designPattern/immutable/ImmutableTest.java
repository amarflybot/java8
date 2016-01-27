package amar.designPattern.immutable;

/**
 * Created by amarendra on 27/01/16.
 */
public class ImmutableTest {

    public static void main(String[] args) {
        Roll roll = new Roll(1);
        Person person = new Person(roll);
        System.out.println(person);
        roll.setInteger(2);
        person.getRoll().setInteger(2);
        System.out.println(person);
    }
}

final class Person{
    final private Roll roll;

    public Person(Roll roll) {
        this.roll = new Roll(roll.getInteger());
    }

    public Roll getRoll() {
        return new Roll(roll.getInteger());
    }

    @Override
    public String toString() {
        return "Person{" +
                "roll=" + roll +
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
