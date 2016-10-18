package amar.rx.composition;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by Amarendra Kumar on 10/18/2016.
 */
public class CompositionExample {

    public static void main(String[] args) throws InterruptedException {

        Object waitMonitor = new Object();
        synchronized (waitMonitor) {

            //UserService
            UserService userService = new UserService();


            Observable.from(userService.fetchUserList()) // Fetch the User
                    .flatMap( User -> Observable.just(User) // for parallel thread
                            .filter((user) -> { // Filter based in Security Status
                                return user.getUserSecurity() != UserSecurityStatus.ADMIN; // No admins required
                            })
                            )
                    .toSortedList((user, user2) -> { // Sort based in Security group
                        return user.getUserSecurity().compareTo(user2.getUserSecurity());
                    })
                    .subscribeOn(Schedulers.io()) // Subscribe on IO scheduler
                    .doOnCompleted(()->{ // Notify the waitMonitor that you are done
                        synchronized (waitMonitor){
                            waitMonitor.notify(); // Notify
                        }
                    })
                    .subscribe( (userList) -> { // Subscribe to Iterate over list and Print
                        userList.forEach((user) -> {
                            System.out.println(user);
                        });

                    });
            waitMonitor.wait();
        }

        System.exit(0);
    }
}
