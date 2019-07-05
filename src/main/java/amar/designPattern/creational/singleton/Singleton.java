package amar.designPattern.creational.singleton;

/**
 * Created by amarendra on 15/01/16.
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        return SingletonHelper.getInstance();
    }

    @Override
    public String toString() {
        return "Singleton Instance";
    }

    private static class SingletonHelper {

        private static Singleton getInstance() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }
}

