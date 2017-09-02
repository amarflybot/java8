package amar.designPattern.observer;

import java.util.Observable;

/**
 * Created by amarendra on 01/09/17.
 */
public class SubjectTest extends Observable {


    private int state;

    @Override
    public String toString() {
        return "SubjectTest{" +
                "state=" + state +
                '}';
    }

    public void setState(final int state) {
        this.state = state;
        setChanged();
        notifyObservers();
        toString();
    }

    public int getState() {
        return state;
    }
}
