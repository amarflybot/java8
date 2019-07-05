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
public class NestedDeserializationTest {
    public static void main(final String[] args) {
        final Dog dog = new Dog();

        try {
            final ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
            objectOutputStream.writeObject(dog);
            System.out.println(dog.cat.rat.i);
            System.out.println(dog.cat.rat.passwd);
            System.out.println(dog.cat.rat.val);
            objectOutputStream.close();
            objectOutputStream.flush();
            byteOutputStream.close();
            byteOutputStream.flush();

            final ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
            final ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            final Dog dog1 = (Dog) objectInputStream.readObject();
            final Cat cat = dog1.cat;
            final Rat rat = cat.rat;
            System.out.println(rat.i);
            System.out.println(rat.passwd);
            System.out.println(rat.val);
            objectInputStream.close();
            byteInputStream.close();

        } catch (final IOException e) {
            e.printStackTrace();
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

class Dog implements Serializable {
    Cat cat = new Cat();

}

class Cat implements Serializable {
    Rat rat = new Rat();
}

class Rat implements Serializable {
    int i = 12;
    transient String passwd = "Abc";
    transient int val = 123123;


    private void writeObject(final ObjectOutputStream objectOutputStream) throws Exception {
        objectOutputStream.defaultWriteObject();
        final String eun = "123" + passwd;
        final int eval = val + 123;
        objectOutputStream.writeObject(eun);
        objectOutputStream.writeInt(eval);
    }

    private void readObject(final ObjectInputStream objectInputStream) throws Exception {
        objectInputStream.defaultReadObject();
        final String dun = (String) objectInputStream.readObject();
        final int dval = objectInputStream.readInt();
        passwd = dun.substring(3);
        val = dval - 123;
    }
}
