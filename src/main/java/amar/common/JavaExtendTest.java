package amar.common;

/**
 * Created by amarendra on 24/10/17.
 */
public class JavaExtendTest {

    public static void main(String[] args) {

        C c1 = new C();
        B b = c1;
        System.out.println("b=" + b);
        B b1 = new B();
        C c2 = (C) b1;
        System.out.println("c2=" + c2);

    }

}

class A {

}

class B extends A {

}

class C extends B {

}
