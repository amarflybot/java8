package amar.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

enum Singleton {

    INSTANCE(12);

    private Integer integer;

    Singleton(final Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(final Integer integer) {
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "integer=" + integer +
                " , hashcode=" + this.hashCode() +
                '}';
    }
}

enum Process {
    S {
        @Override
        void invoke() {
            try {
                EnumSerialization.serialize();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    },
    D {
        @Override
        void invoke() {
            try {
                EnumSerialization.deserialize();
            } catch (final IOException e) {
                e.printStackTrace();
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    },
    SD {
        @Override
        void invoke() {
            try {
                EnumSerialization.serialize();
                EnumSerialization.deserialize();
            } catch (final IOException e) {
                e.printStackTrace();
            } catch (final ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    abstract void invoke();
}

/**
 * Created by amarendra on 05/09/17.
 */
public class EnumSerialization {

    public static void main(final String[] args) throws IOException, ClassNotFoundException {

        if (!(args[0].equals("S") || args[0].equals("D") || args[0].equals("SD"))) {
            System.out.println("Pass S and D to proceed");
            return;
        }
        Process.valueOf(args[0]).invoke();

    }

    public static void serialize() throws IOException {
        final FileOutputStream byteArrayOutputStream = new FileOutputStream(new File("/Users/amarendra/Documents/file.ser"));
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        final Singleton person = Singleton.INSTANCE;
        System.out.println(person);
        objectOutputStream.writeObject(person);
        byteArrayOutputStream.close();
        byteArrayOutputStream.flush();
        objectOutputStream.close();
        objectOutputStream.flush();
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        final FileInputStream inputStream = new FileInputStream(new File("/Users/amarendra/Documents/file.ser"));
        final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        final Singleton singleton = (Singleton) objectInputStream.readObject();
        System.out.println(singleton);
        inputStream.close();
        objectInputStream.close();
    }


}

class Person implements Serializable {


    private static final long serialVersionUID = -784181159770743576L;
    private Long id;
    private String name;
    private String roll;

    public Person(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Person(final Long id, final String name, final String roll) {
        this.id = id;
        this.name = name;
        this.roll = roll;
    }

    public String getRoll() {
        return roll;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hashcode=" + hashCode() +
                '}';
    }
}

class PersonSingleton implements Serializable {

    private static PersonSingleton personSingleton;

    public static PersonSingleton getInstance() {
        if (personSingleton == null) {
            synchronized (PersonSingleton.class) {
                if (personSingleton == null) {
                    personSingleton = new PersonSingleton();
                }
            }
        }
        return personSingleton;
    }

    protected Object readResolve() {
        return getInstance();
    }

    @Override
    public String toString() {
        return "PersonSingleton{ hashCode: " + hashCode() + "}";
    }
}
