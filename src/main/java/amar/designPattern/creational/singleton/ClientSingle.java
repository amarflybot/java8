package amar.designPattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Created by amarendra on 04/09/17.
 */
public class ClientSingle {

    public static void main(final String[] args) throws IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        final Singleton instance = Singleton.getInstance();
        final Singleton instance1 = Singleton.getInstance();

        System.out.println(System.identityHashCode(instance));
        System.out.println(System.identityHashCode(instance1));

        final Integer inr1 = Integer.valueOf(1);
        final Integer inr2 = Integer.valueOf(1);
        final Integer inr3 = Integer.valueOf(10);

        System.out.println(System.identityHashCode(inr1));
        System.out.println(System.identityHashCode(inr2));
        System.out.println(System.identityHashCode(inr3));

        final Class<?> aClass = Class.forName("amar.designPattern.creational.singleton.Singleton");

        final Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        for (final Constructor constructor : declaredConstructors) {
            if (Modifier.isPrivate(constructor.getModifiers())) {
                constructor.setAccessible(true);
                final Singleton newInstance = (Singleton) constructor.newInstance();
                System.out.println("New Instance by reflection" + newInstance);

                System.out.println(System.identityHashCode(newInstance));
            }
        }

    }
}
