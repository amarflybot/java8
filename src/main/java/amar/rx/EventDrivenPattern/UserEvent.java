package amar.rx.EventDrivenPattern;

import java.util.Date;

/**
 * Created by amarendra on 22/10/16.
 */
public class UserEvent {

    private final String username;
    private final String emailAddress;
    private final Date eventDate;

    public UserEvent(String username, String emailAddress, Date eventDate) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.eventDate = eventDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Date getEventDate() {
        return new Date(eventDate.getTime());
    }
}
