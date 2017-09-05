package amar.designPattern.behavioural.observer;

/**
 * Created by amarendra on 05/09/17.
 */
public class MailClient extends Observer{

    private Subject subject;

    public MailClient(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    void update() {
        System.out.println("Mail Stream: "+ subject.getState());
    }

    public void sendMessage(String str){
        this.subject.setState(str);
    }
}
