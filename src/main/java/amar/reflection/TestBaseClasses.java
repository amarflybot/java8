package amar.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Amarendra Kumar
 * @date 04-01-2016 AM 11:27.
 */
public class TestBaseClasses {
    public static void main(String[] args) throws InvocationTargetException {
        // Get Class using reflection
        Class<?> concreteClass = null;
        try {
            concreteClass = Class.forName("amar.reflection.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ConcreteClass object = null;
        try {
            Constructor<?>[] constructors = concreteClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                if (Modifier.isPrivate(constructor.getModifiers())) {
                    constructor.setAccessible(true);
                    object = (ConcreteClass) constructor.newInstance();
                }
                //System.out.println(constructor.getModifiers());
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(concreteClass.getCanonicalName()); // amar.ConcreteClass
        Method[] methods = concreteClass.getMethods();
        System.out.println(methods.toString());
        System.out.println(concreteClass.getFields().toString());
        try {
            System.out.println(methods[0]);
            if (methods[0].getName().equals("method5")) {
                methods[0].invoke(object, 3);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /*try {
            concreteClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        Class<?> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName()); // prints boolean

        Class<?> cDouble = Double.TYPE;
        System.out.println(cDouble.getCanonicalName()); // prints double

        Class<?> cDoubleArray = null;
        try {
            cDoubleArray = Class.forName("[D");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(cDoubleArray.getCanonicalName()); //prints double[]

        Class<?> twoDStringArray = String[][].class;
        System.out.println(twoDStringArray.getCanonicalName()); // prints java.lang.String[][]
    }
}
