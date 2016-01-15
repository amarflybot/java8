package amar.designPattern.singletone;

/**
 * Created by amarendra on 15/01/16.
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }
    public static Singleton getInstance(){

        if(singleton == null) {
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }

    @Override
    public String toString() {
        return "Singleton Instance";
    }
}

class SingletonTest{
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
