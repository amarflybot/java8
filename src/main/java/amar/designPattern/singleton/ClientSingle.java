package amar.designPattern.singleton;

/**
 * Created by amarendra on 04/09/17.
 */
public class ClientSingle {

    public static void main(String[] args) {

        Singleton instance = Singleton.getInstance(2);
        Singleton instance1 = Singleton.getInstance(1);

        System.out.println(System.identityHashCode(instance));
        System.out.println(System.identityHashCode(instance1));

        Integer inr1 = Integer.valueOf(1);
        Integer inr2 = Integer.valueOf(1);
        Integer inr3 = Integer.valueOf(10);

        System.out.println(System.identityHashCode(inr1));
        System.out.println(System.identityHashCode(inr2));
        System.out.println(System.identityHashCode(inr3));

    }
}
