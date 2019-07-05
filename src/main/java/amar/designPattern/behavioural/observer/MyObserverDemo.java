package amar.designPattern.behavioural.observer;

/**
 * Created by amarendra on 05/09/17.
 */
public class MyObserverDemo {

    public static void main(final String[] args) {


        final Subject subject = new MessageSubject();

        final PhoneClient phoneClient = new PhoneClient(subject);
        final MailClient mailClient = new MailClient(subject);

        phoneClient.addMessage("Here is a new message from Phone Client");
        mailClient.sendMessage("New message from Mail Client");
    }

}
