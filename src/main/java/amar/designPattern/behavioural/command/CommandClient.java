package amar.designPattern.behavioural.command;

/**
 * Created by amarendra on 05/09/17.
 */
public class CommandClient {

    public static void main(final String[] args) {

        final Light light = new Light();

        final Switch lightSwitch = new Switch();

        final Command onCommand = new OnCommand(light);
        final Command toggleCommand = new ToggleCommand(light);

        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);

    }
}
