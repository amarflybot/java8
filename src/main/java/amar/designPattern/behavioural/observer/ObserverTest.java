package amar.designPattern.behavioural.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by amarendra on 01/09/17.
 */
public class ObserverTest implements Observer {


    @Override
    public void update(final Observable o, final Object arg) {
        System.out.println("In Observer Test, Update method");
        System.out.println(o.toString());
        o.notifyObservers(arg);
    }
}
