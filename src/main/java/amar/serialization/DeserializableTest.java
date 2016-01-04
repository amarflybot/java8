package amar.serialization;

import java.io.*;

/**
 * Created by amarendra on 04/01/16.
 */
public class DeserializableTest {
    public static void main(String[] args) {

        try {
            System.out.println("=====================Serialization=====================");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            Elephant elephant = new Elephant();
            elephant.i=888;
            elephant.j=999;
            objectOutputStream.writeObject(elephant);
            objectOutputStream.close();
            objectOutputStream.flush();
            byteArrayOutputStream.close();
            byteArrayOutputStream.flush();
            System.out.println("=====================Deserialization=====================");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Elephant elephant1 = (Elephant) objectInputStream.readObject();
            System.out.println(elephant1.i + " ----- " +elephant1.j);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

class Elephant extends Animal implements Serializable{
    int j = 5;

    public Elephant() {
        System.out.println("Default Constructor :: Elephant");
    }
}
