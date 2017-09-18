package amar.primitive;

/**
 * Created by amarendra on 17/09/17.
 *
 * "bsilfd"
 */
public class PrimitivesTest {

    public static void main(String[] args) {

        byte b = 127;
        short sh = b;
        short sh1 = 32767;

        int in = sh1;

        long ln = in;
        long ln1 = 123l;

        float fl = ln1;
        float fl1 = 123456f;

        double db = fl1;
        double db1 = 123123d;

        boolean b1 = true;
        char ch1 = 'c';

        System.out.println("Byte: "+ b);
        System.out.println("Short: "+ sh);
        System.out.println("Short: "+ sh1);
        System.out.println("Int: "+ in);
        System.out.println("Long: "+ ln);
        System.out.println("Long1: "+ ln1);
        System.out.println("Float: "+ fl);
        System.out.println("Float1: "+ fl1);
        System.out.println("Double: "+ db);
        System.out.println("Double1: "+ db1);
        System.out.println("Boolean: "+ b1);
        System.out.println("Char: "+ ch1);


    }

}
