package amar.scjp;

/**
 * Created by amarendra on 15/01/16.
 */

class Person{
    String name;
    String age;

    public Person(String name, String age) {
        name = name;
        this.age = age;
    }
    public void callSomeone(int q, double a){

    }
    static {
        System.out.println("IN static Block of Person");
    }

    public static void inHere(){
        System.out.println("IN static inHere of Person");
    }

}

class Boy extends Outer{

    String roll;
    static {
        System.out.println("IN static Block of boy");
    }

    public Boy(String name, String age, String roll) {
        //super(name, age);
        this.roll = roll;

    }

    protected void callSomeone(){

    }

    public void callSomeone(int q, double a){

    }
    public static void inHere(){
        System.out.println("IN static inHere of Boy");
    }

}
public class Test {

    public static void main(String[] args) {
        Outer.Inner outer = new Outer.Inner(){

        };
    }



}
class Outer {           // an outer class has a static nested class
    static interface Inner {}
}

