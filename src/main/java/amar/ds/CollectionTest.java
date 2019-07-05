package amar.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by kumarao on 21-01-2016.
 */
public class CollectionTest {

    public static void main(final String[] args) {
        final List<Client> clients = new ArrayList<>();
        final Client client = new Client("x");
        String name = client.getName();
        name = "Amar";
        clients.add(client);
        clients.add(new Client("asdasd"));
        clients.add(new Client("gfjfgj"));


        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(final Client o1, final Client o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        System.out.println(clients);
    }
}

final class Client {

    final private String name;
    private List<Client> clients;

    Client(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
