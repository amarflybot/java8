package amar.rx.EventDrivenPattern;

import java.util.Date;

/**
 * Created by amarendra on 22/10/16.
 */
public class CreateUserEvent extends UserEvent {

    public CreateUserEvent(String username, String emailID) {
        super(username, emailID, new Date());
    }
}
