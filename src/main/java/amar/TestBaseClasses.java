package amar;

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
        System.out.println(concreteClass.getCanonicalName()); // amar.ConcreteClass
        try {
            concreteClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
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
