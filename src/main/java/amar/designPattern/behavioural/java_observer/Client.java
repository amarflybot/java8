package amar.designPattern.behavioural.java_observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by amarendra on 05/09/17.
 */
public class Client implements Observer {

    private String name;

    public Client(final String name) {
        this.name = name;
    }

    @Override
    public void update(final Observable o, final Object arg) {
        System.out.println("Update " + name + "'s stream, someone updated.");
    }
}
