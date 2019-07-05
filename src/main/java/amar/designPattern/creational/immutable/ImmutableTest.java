package amar.designPattern.creational.immutable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by amarendra on 27/01/16.
 */
public class ImmutableTest {

    public static void main(final String[] args) {
        final Roll roll = new Roll(1);
        final Roll roll12 = new Roll(12);
        final Roll roll13 = new Roll(13);
        final Roll roll14 = new Roll(14);
        final Roll roll15 = new Roll(15);
        final ArrayList<Roll> rollList = new ArrayList<>();
        rollList.add(roll);
        rollList.add(roll12);
        rollList.add(roll13);
        rollList.add(roll14);
        rollList.add(roll15);
        final Date date = new Date();
        final Person person = new Person(roll, date, rollList);
        System.out.println(person);
        roll.setInteger(2);
        person.getRoll().setInteger(2);
        person.getDate().setTime(new Date().getTime());
        person.getRollList().add(new Roll(21));
        final Roll roll1 = person.getRollList().get(0);
        roll1.setInteger(45);
        System.out.println(person);

    }
}

