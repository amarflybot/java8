package amar.designPattern.behavioural.observer;

/**
 * Created by amarendra on 05/09/17.
 */
public abstract class Observer {
    protected Subject subject;

    abstract void update();
}
