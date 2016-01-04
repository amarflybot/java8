package amar.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Amarendra Kumar
 * @date 04-01-2016 AM 11:27.
 */
public class TestBaseClasses {
    public static void main(String[] args) {
        // Get Class using reflection
        Class<?> concreteClass = null;
        try {
            concreteClass = Class.forName("amar.ConcreteClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Object object = null;
        try {
            object = concreteClass.newInstance();
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
            methods[0].invoke(object, null);
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
