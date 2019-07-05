package amar.designPattern.behavioural.command;

/**
 * Created by amarendra on 05/09/17.
 * This is a receiver.
 */
public class Light {

    private boolean isOn;

    public void toggle() {
        if (isOn) {
            off();
            isOn = false;
        } else {
            on();
            isOn = true;
        }
    }

    public void on() {
        System.out.println("Light switch on");
    }

    public void off() {
        System.out.println("Light switch off");
    }
}
