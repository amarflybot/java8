package amar.designPattern.behavioural.observer;

/**
 * Created by amarendra on 05/09/17.
 */
public class MyObserverDemo {

    public static void main(String[] args) {


        Subject subject = new MessageSubject();

        PhoneClient phoneClient = new PhoneClient(subject);
        MailClient mailClient = new MailClient(subject);

        phoneClient.addMessage("Here is a new message from Phone Client");
        mailClient.sendMessage("New message from Mail Client");
    }

}
