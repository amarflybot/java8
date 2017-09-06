package amar.serialization;

import java.io.*;

/**
 * Created by amarendra on 05/09/17.
 */
public class EnumSerialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //serialize();

        deserialize();
    }

    public static void serialize() throws IOException {
        FileOutputStream byteArrayOutputStream = new FileOutputStream(new File("/Users/amarendra/Documents/file.ser"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        Person person = new Person(1L,"Amar");
        System.out.println(person);
        objectOutputStream.writeObject(person);
        byteArrayOutputStream.close();
        byteArrayOutputStream.flush();
        objectOutputStream.close();
        objectOutputStream.flush();
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(new File("/Users/amarendra/Documents/file.ser"));
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Person singleton = (Person) objectInputStream.readObject();
        System.out.println(singleton);
        inputStream.close();
        objectInputStream.close();
    }


}

/*enum Singleton implements Serializable{
    INSATNCE;

    protected Object readResolve(){
        return INSATNCE;
    }

    private Integer integer;

    public void setInteger(final Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "integer=" + integer +
                '}';
    }
}*/

class Person implements Serializable{


    private static final long serialVersionUID = -784181159770743576L;
    private Long id;
    private String name;
    private String roll;

    private static Person person;

    public String getRoll() {
        return roll;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Person(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Person(final Long id, final String name, final String roll) {
        this.id = id;
        this.name = name;
        this.roll = roll;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
