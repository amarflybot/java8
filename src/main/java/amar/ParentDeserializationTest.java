package amar;import java.io.*;import java.io.ByteArrayInputStream;import java.io.ByteArrayOutputStream;import java.io.IOException;import java.io.ObjectInputStream;import java.io.ObjectOutputStream;import java.io.Serializable;import java.lang.ClassNotFoundException;import java.lang.String;import java.lang.System;

/**
 * @author Amarendra Kumar
 * @date 04-01-2016 AM 10:40.
 */
public class ParentDeserializationTest {

    public static void main(String[] args) {
        try {
            System.out.println("Creating...");
            Child c = new Child(1);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            c.field = 10;
            System.out.println("Serializing...");
            oos.writeObject(c);
            oos.flush();
            baos.flush();
            oos.close();
            baos.close();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("---------------------------------------------------");
            System.out.println("Deserializing...");
            Child c1 = (Child)ois.readObject();
            System.out.println("c1.i="+c1.getI());
            System.out.println("c1.field="+c1.getField());
        } catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public static class Parent {
        protected int field;
        protected Parent(){
            field = 5;
            System.out.println("Parent::Constructor");
        }
        public int getField() {
            return field;
        }
    }

    public static class Child extends Parent implements Serializable{
        protected int i;

        public Child() {
            System.out.println("Child::Default Constructor");
        }

        public Child(int i){
            this.i = i;
            System.out.println("Child::Constructor");
        }
        public int getI() {
            return i;
        }
    }
}
