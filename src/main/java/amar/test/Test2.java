package amar.test;

/**
 * Created by amarendra on 05/09/17.
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        /*Mammal mammal = new Mammal(4);
        System.out.println(mammal);
        mammal.getSomething();
        some(mammal);
        System.out.println(mammal);*/

        /*String str = "ABC";
        String str1 = "BCA";
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());*/
    }

    private static void some(Mammal mammal) {
        mammal = new Mammal(3);
        System.out.println(mammal);
    }
}

class Person1 extends Mammal{

    public Person1(final Integer i) {
        super(i);
        getSomething();
    }


}

class Mammal{

    private Integer i ;

    public Mammal(final Integer i) {
        this.i = i;
    }

    void getSomething(){

    }

    public Integer getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "i=" + i +
                '}';
    }
}
