package amar.rx.EventDrivenPattern;

import rx.Observer;
import rx.functions.Action1;

/**
 * Created by amarendra on 22/10/16.
 */
public interface UserService {

    void addUser(String username, String emailID);

    void subscribeToUserEvents(Observer<UserEvent> subscriber);

    void subscribeToUserEvents(Action1<UserEvent> onNext);
}
