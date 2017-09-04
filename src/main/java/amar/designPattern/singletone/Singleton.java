package amar.designPattern.singletone;

/**
 * Created by amarendra on 15/01/16.
 */
public class Singleton {

    private static Singleton singleton;
    private final Integer integer;

    private Singleton(final int i) {
        this.integer = i;
    }

    private static class SingletonHelper{

        private static Singleton getInstance(final int i){
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton(i);
                    }
                }
            }
            return singleton;
        }
    }

    public Integer getInteger() {
        return integer;
    }

    @Override
    public String toString() {
        return "Singleton Instance";
    }

    public static Singleton getInstance(final int i) {
        return SingletonHelper.getInstance(i);
    }
}

