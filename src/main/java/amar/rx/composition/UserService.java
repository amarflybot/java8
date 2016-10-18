package amar.rx.composition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by V691139 on 10/18/2016.
 */
public class UserService {

    private final List<User> userList;

    public UserService(){
        userList = new ArrayList<>();

        userList.add(new User("Amar", "amar@gmail.com", UserSecurityStatus.ADMIN));
        userList.add(new User("Prateek", "prateek@gmail.com", UserSecurityStatus.MODERATOR));
        userList.add(new User("Piyush", "piyush@gmail.com", UserSecurityStatus.GUEST));
        userList.add(new User("Abhilash", "abhilash@gmail.com", UserSecurityStatus.GUEST));
        userList.add(new User("Kalyan", "kalyan@gmail.com", UserSecurityStatus.MODERATOR));
    }

    public List<User> fetchUserList(){
        return Collections.unmodifiableList(userList);
    }
}
