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
    public static void main(String[] args) {
        Dog dog = new Dog();

        try {
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
            objectOutputStream.writeObject(dog);
            System.out.println(dog.cat.rat.i);
            System.out.println(dog.cat.rat.passwd);
            System.out.println(dog.cat.rat.val);
            objectOutputStream.close();
            objectOutputStream.flush();
            byteOutputStream.close();
            byteOutputStream.flush();

            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(byteOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteInputStream);
            Dog dog1 = (Dog) objectInputStream.readObject();
            Cat cat = dog1.cat;
            Rat rat = cat.rat;
            System.out.println(rat.i);
            System.out.println(rat.passwd);
            System.out.println(rat.val);
            objectInputStream.close();
            byteInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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


    private void writeObject(ObjectOutputStream objectOutputStream) throws Exception {
        objectOutputStream.defaultWriteObject();
        String eun = "123" + passwd;
        int eval = val + 123;
        objectOutputStream.writeObject(eun);
        objectOutputStream.writeInt(eval);
    }

    private void readObject(ObjectInputStream objectInputStream) throws Exception {
        objectInputStream.defaultReadObject();
        String dun = (String) objectInputStream.readObject();
        int dval = objectInputStream.readInt();
        passwd = dun.substring(3);
        val = dval - 123;
    }
}
