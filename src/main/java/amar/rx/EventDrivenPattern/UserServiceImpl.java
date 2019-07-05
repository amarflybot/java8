package amar.rx.EventDrivenPattern;

import rx.Observer;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/**
 * Created by amarendra on 22/10/16.
 */
public class UserServiceImpl implements UserService {

    private final PublishSubject<UserEvent> userServiceEvent;

    public UserServiceImpl() {
        this.userServiceEvent = PublishSubject.create();
    }

    @Override
    public void addUser(final String username, final String emailID) {

        System.out.println("UserServiceImpl: addUser " + username + " , " + emailID);

        final UserEvent userEvent = new CreateUserEvent(username, emailID);

        userServiceEvent.onNext(userEvent);

    }

    @Override
    public void subscribeToUserEvents(final Observer<UserEvent> subscriber) {
        userServiceEvent.subscribe(subscriber);
    }

    @Override
    public void subscribeToUserEvents(final Action1<UserEvent> onNext) {
        userServiceEvent.subscribe(onNext);
    }
}
