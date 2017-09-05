package amar.designPattern.behavioural.command;

/**
 * Created by amarendra on 05/09/17.
 */
public class ToggleCommand implements Command{

    private Light light;

    public ToggleCommand(final Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.toggle();
    }
}
