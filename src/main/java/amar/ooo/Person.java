package amar.ooo;

/**
 * Created by amarendra on 25/07/16.
 */
public class Person extends Mammal {

    public static void main(final String[] args) {
        final String str = new String("ABC");
        final String str1 = "ABC";
        System.out.println(str == str1);

        final String intern = str.intern();

        System.out.println(intern == str1);
    }

    public void walk(final Integer number) {
        System.out.println("Walking in Person kms: " + number);
    }

    public Integer getNumber() {
        return 10;
    }

}
