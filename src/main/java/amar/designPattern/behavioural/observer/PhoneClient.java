package amar.designPattern.behavioural.observer;

/**
 * Created by amarendra on 05/09/17.
 */
public class PhoneClient extends Observer {


    public PhoneClient(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Phone Stream: " + subject.getState());
    }

    public void addMessage(final String s) {
        this.subject.setState(s);
    }
}
