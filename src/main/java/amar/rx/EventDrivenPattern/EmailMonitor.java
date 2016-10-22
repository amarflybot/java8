package amar.rx.EventDrivenPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amarendra on 22/10/16.
 */
public class EmailMonitor {

    private EmailService emailService;

    public EmailMonitor(EmailService emailService, UserService userService) {
        this.emailService = emailService;

        userService.subscribeToUserEvents(this::handleUserEvent);
    }

    private void handleUserEvent(UserEvent event){
        System.out.println("EmailMonitorServiceImpl::handleUserEvent - " +
        Thread.currentThread().getName());

        List<String> recipList = new ArrayList<>();
        recipList.add(event.getEmailAddress());
        String text = "Hi " + event.getUsername() + "Welcome to PluralSight";
        emailService.sendEmail(recipList, "noReply@gmail.com", "Welcome to PluralSight", text);
    }

}
