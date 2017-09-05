package amar.designPattern.creational.immutable;

import java.util.ArrayList;
import java.util.Date;

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

