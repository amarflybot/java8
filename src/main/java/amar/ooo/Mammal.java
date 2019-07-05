package amar.ooo;

/**
 * Created by amarendra on 25/07/16.
 */
public abstract class Mammal {

    public void walk(final Number number) {
        System.out.println("Walking in Mammal kms: " + number);
    }

    public Number getNumber() {
        return 9;
    }

}
