package amar.designPattern.behavioural.java_observer;

import java.util.Collections;

/**
 * Created by amarendra on 05/09/17.
 */
public class ObserverDemo {

    public static void main(String[] args) {

        TwitterStream twitterStream = new TwitterStream();

        Client client = new Client("Amar");
        Client client1 = new Client("Alka");

        twitterStream.addObserver(client);
        twitterStream.addObserver(client1);

        twitterStream.someOneTweeted();
    }
}
