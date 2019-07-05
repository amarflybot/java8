package amar.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by amarendra on 04/01/16.
 */
public class DeserializableTest {
    public static void main(final String[] args) {

        try {
            System.out.println("=====================Serialization=====================");
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            final Elephant elephant = new Elephant();
            elephant.i = 888;
            elephant.j = 999;
            objectOutputStream.writeObject(elephant);
            objectOutputStream.close();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            System.out.println("=====================Deserialization=====================");
            final ByteArrayInputStream byteArrayInputStream =
                    new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            final Elephant elephant1 = (Elephant) objectInputStream.readObject();
            System.out.println(elephant1.i + " ----- " + elephant1.j);
        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Animal {
    int i = 2;

    // This default Constructor is required for Deserialization
    public Animal() {
        System.out.println("Default Constructor :: Animal");
    }
}

class Elephant extends Animal implements Serializable {
    int j = 5;

    public Elephant() {
        System.out.println("Default Constructor :: Elephant");
    }
}
