package amar.designPattern.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 05/09/17.
 */
public abstract class Subject {

    private List<Observer> observers = new ArrayList();

    abstract String getState();

    abstract void setState(String state);

    public void attach(final Observer observer) {
        observers.add(observer);
    }

    public void detach(final Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers() {
        observers.forEach(observer -> {
            observer.update();
        });
    }

}
