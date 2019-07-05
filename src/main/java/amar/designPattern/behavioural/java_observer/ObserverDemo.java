package amar.designPattern.behavioural.java_observer;

/**
 * Created by amarendra on 05/09/17.
 */
public class ObserverDemo {

    public static void main(final String[] args) {

        final TwitterStream twitterStream = new TwitterStream();

        final Client client = new Client("Amar");
        final Client client1 = new Client("Alka");

        twitterStream.addObserver(client);
        twitterStream.addObserver(client1);

        twitterStream.someOneTweeted();
    }
}
