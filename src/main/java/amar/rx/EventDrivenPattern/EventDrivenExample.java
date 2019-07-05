package amar.rx.EventDrivenPattern;

/**
 * Created by amarendra on 22/10/16.
 */
public class EventDrivenExample {

    public static void main(final String[] args) throws InterruptedException {

        final EmailService emailService = new EmailServiceImpl();

        final UserService userService = new UserServiceImpl();

        new EmailMonitor(emailService, userService);

        userService.addUser("Amar", "amar@gmail.com");

        Thread.sleep(2000);

        System.exit(0);
    }
}
