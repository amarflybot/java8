package amar.rx.EventDrivenPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 22/10/16.
 */
public class EmailMonitor {

    private EmailService emailService;

    public EmailMonitor(final EmailService emailService, final UserService userService) {
        this.emailService = emailService;

        userService.subscribeToUserEvents(this::handleUserEvent);
    }

    private void handleUserEvent(final UserEvent event) {
        System.out.println("EmailMonitorServiceImpl::handleUserEvent - " +
                Thread.currentThread().getName());

        final List<String> recipList = new ArrayList<>();
        recipList.add(event.getEmailAddress());
        final String text = "Hi " + event.getUsername() + "Welcome to PluralSight";
        emailService.sendEmail(recipList, "noReply@gmail.com", "Welcome to PluralSight", text);
    }

}
