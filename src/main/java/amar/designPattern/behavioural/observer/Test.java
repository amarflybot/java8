package amar.designPattern.behavioural.observer;

/**
 * Created by amarendra on 01/09/17.
 */
public class Test {

    public static void main(String[] args) {

        SubjectTest subject = new SubjectTest();
        ObserverTest observer = new ObserverTest();

        subject.addObserver(observer);

        subject.setState(15);



    }
}
