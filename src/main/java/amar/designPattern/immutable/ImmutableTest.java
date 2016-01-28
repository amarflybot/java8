package amar.designPattern.immutable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by amarendra on 27/01/16.
 */
public class ImmutableTest {

    public static void main(String[] args) {
        Roll roll = new Roll(1);
        Roll roll12 = new Roll(12);
        Roll roll13 = new Roll(13);
        Roll roll14 = new Roll(14);
        Roll roll15 = new Roll(15);
        ArrayList<Roll> rollList = new ArrayList<>();
        rollList.add(roll);
        rollList.add(roll12);
        rollList.add(roll13);
        rollList.add(roll14);
        rollList.add(roll15);
        Date date = new Date();
        Person person = new Person(roll, date, rollList);
        System.out.println(person);
        roll.setInteger(2);
        person.getRoll().setInteger(2);
        person.getDate().setTime(new Date().getTime());
        person.getRollList().add(new Roll(21));
        Roll roll1 = person.getRollList().get(0);
        roll1.setInteger(45);
        System.out.println(person);

    }
}

final class Person{
    final private Roll roll;
    final private Date date;
    final private ArrayList<Roll> rollList;

    public Person(Roll roll, Date date, ArrayList<Roll> rollList) {
        this.roll = new Roll(roll.getInteger());
        this.date = new Date(date.getTime());
        this.rollList = getRollsList(rollList);
    }

    public Roll getRoll() {
        return new Roll(roll.getInteger());
    }

    public Date getDate() {
        return new Date(this.date.getTime());
    }

    public ArrayList<Roll> getRollList() {
        ArrayList<Roll> rollArrayList = getRollsList(rollList);
        return rollArrayList;
    }

    private ArrayList<Roll> getRollsList(ArrayList<Roll> rollListnew) {
        ArrayList<Roll> rollArrayList = new ArrayList<>();
        for(Roll roll : rollListnew){
            rollArrayList.add(new Roll(roll.getInteger()));
        }
        return rollArrayList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "roll=" + roll +
                ", date=" + date +
                ", rollList=" + rollList +
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
