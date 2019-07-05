package amar.designPattern.behavioural.observer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by amarendra on 05/09/17.
 */
public class MessageSubject extends Subject {

    private Deque<String> deque = new ArrayDeque<>();

    @Override
    String getState() {
        return this.deque.getLast();
    }

    @Override
    void setState(final String state) {
        this.deque.add(state);
        this.notifyAllObservers();
    }
}
