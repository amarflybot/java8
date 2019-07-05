package amar.designPattern.creational.immutable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by kumarao on 06-08-2016.
 */
final class Person {
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
        for (Roll roll : rollListnew) {
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
