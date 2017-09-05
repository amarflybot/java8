package amar.designPattern.behavioural.command;

/**
 * Created by amarendra on 05/09/17.
 * Concrete command
 */
public class OnCommand implements Command {

    private Light light;

    public OnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }
}
