package amar.externalization;

import java.io.*;

/**
 * Created by amarendra on 04/01/16.
 */
public class ExternizableTest {

    public static void main(String[] args) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            Account account = new Account(2,"MyName");
            System.out.println("Account Object Created");
            objectOutputStream.writeObject(account);
            System.out.println("Externalized");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            System.out.println("DeExternalization Started");
            Account account1 = (Account) objectInputStream.readObject();
            System.out.println("DeExternalization Done");
            System.out.println(account1.no);
            System.out.println(account1.name);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Account implements Externalizable{
    int no;
    String name;

    // This default Constructor is required to create the object while Deserialization.
    public Account() {
        System.out.println("In Default Constructor :: Account");
    }

    public Account(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("in writeExternal");
        out.writeObject(no);
        out.writeObject(name);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("in readExternal");
        no = (int) in.readObject();
        name = (String) in.readObject();
    }
}
