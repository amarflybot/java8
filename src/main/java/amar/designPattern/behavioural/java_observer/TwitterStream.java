package amar.designPattern.behavioural.java_observer;

import java.util.Observable;

/**
 * Created by amarendra on 05/09/17.
 */
public class TwitterStream extends Observable{

    public void someOneTweeted() {
        setChanged();
        notifyObservers();
    }
}
