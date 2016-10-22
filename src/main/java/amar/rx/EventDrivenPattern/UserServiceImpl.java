package amar.rx.EventDrivenPattern;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by amarendra on 22/10/16.
 */
public class UserServiceImpl implements UserService{

    private final PublishSubject<UserEvent> userServiceEvent;

    public UserServiceImpl() {
        this.userServiceEvent = PublishSubject.create();
    }

    @Override
    public void addUser(String username, String emailID) {

        System.out.println("UserServiceImpl: addUser "+ username + " , "+ emailID);

        UserEvent userEvent = new CreateUserEvent(username, emailID);

        userServiceEvent.onNext(userEvent);

    }

    @Override
    public void subscribeToUserEvents(Observer<UserEvent> subscriber) {
        userServiceEvent.subscribe(subscriber);
    }

    @Override
    public void subscribeToUserEvents(Action1<UserEvent> onNext) {
        userServiceEvent.subscribe(onNext);
    }
}
