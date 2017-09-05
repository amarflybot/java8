package amar.designPattern.behavioural.command;

/**
 * Created by amarendra on 05/09/17.
 * This is the invoker
 */
public class Switch {


    public void storeAndExecute(final Command command) {
        command.execute();
    }
}
