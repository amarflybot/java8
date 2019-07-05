package amar.scjp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by amarendra on 15/01/16.
 */

class Person {
    static {
        System.out.println("IN static Block of Person");
    }

    String name;
    String age;

    public Person(String name, String age) {
        name = name;
        this.age = age;
    }

    public static void inHere() {
        System.out.println("IN static inHere of Person");
    }

    public void callSomeone(int q, double a) {

    }

}

class Boy extends Outer {

    static {
        System.out.println("IN static Block of boy");
    }

    String roll;

    public Boy(String name, String age, String roll) {
        //super(name, age);
        this.roll = roll;

    }

    public static void inHere() {
        System.out.println("IN static inHere of Boy");
    }

    protected void callSomeone() {

    }

    public void callSomeone(int q, double a) {

    }

}

public class Test {

    public static void main(String[] args) {
        Outer.Inner outer = new Outer.Inner() {

        };
    }

    /**
     * This method makes a "deep clone" of any Java object it is given.
     */
    public static Object deepClone(Object object) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}

class Outer {           // an outer class has a static nested class
    interface Inner {
    }
}

