package amar.designPattern.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/**
 * Created by amarendra on 04/09/17.
 */
public class SingletonEnumTest {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {

        final SingletonEnum instance = SingletonEnum.INSTANCE;
        instance.setInteger(3);

        System.out.println(System.identityHashCode(instance));

        final SingletonEnum instance1 = SingletonEnum.INSTANCE;
        instance.setInteger(4);

        System.out.println(System.identityHashCode(instance1));


        final Class<?> aClass = Class.forName("amar.designPattern.creational.singleton.SingletonEnum");

        final Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        for (Constructor constructor: declaredConstructors) {
            if (Modifier.isPrivate(constructor.getModifiers())){
                constructor.setAccessible(true);
            }
            final SingletonEnum newInstance = (SingletonEnum) constructor.newInstance();

            System.out.println("newInstance.getInteger() " +newInstance.getInteger());
            System.out.println(System.identityHashCode(newInstance));
        }

    }

}
