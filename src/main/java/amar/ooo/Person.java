package amar.ooo;

/**
 * Created by amarendra on 25/07/16.
 */
public class Person extends Mammal {

    public void walk(Integer number) {
        System.out.println("Walking in Person kms: "+number);
    }

    public Integer getNumber() {
        return 10;
    }
}
