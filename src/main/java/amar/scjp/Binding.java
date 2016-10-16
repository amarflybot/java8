package amar.scjp;


/**
 * Created by amarendra on 22/03/16.
 */
public class Binding {

    public static void main(String[] args) {

        A a1 = new A();
        A.method();

        A b1 = new B();
        A.method();

    }
}

class A {
    public static void method(){
        System.out.println("In Class A");
    }
}

class B extends A {

    public static void method(){
        System.out.println("In Class B");
    }
}
