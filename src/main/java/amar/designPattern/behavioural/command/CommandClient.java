package amar.designPattern.behavioural.command;

/**
 * Created by amarendra on 05/09/17.
 */
public class CommandClient {

    public static void main(String[] args) {

        Light light = new Light();

        Switch lightSwitch = new Switch();

        Command onCommand = new OnCommand(light);
        Command toggleCommand = new ToggleCommand(light);

        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);
        lightSwitch.storeAndExecute(toggleCommand);

    }
}
