package amar.rx.composition;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class User {

    private String name;
    private String email;
    private UserSecurityStatus userSecurity;

    public User(final String name, final String email, final UserSecurityStatus userSecurity) {
        this.name = name;
        this.email = email;
        this.userSecurity = userSecurity;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserSecurityStatus getUserSecurity() {
        return userSecurity;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userSecurity=" + userSecurity +
                '}';
    }
}
