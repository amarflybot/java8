package amar.primitive;

/**
 * Created by amarendra on 17/09/17.
 * <p>
 * "bsilfd"
 */
public class PrimitivesTest {

    public static void main(final String[] args) {

        final byte b = 127;
        final short sh = b;
        final short sh1 = 32767;

        final int in = sh1;

        final long ln = in;
        final long ln1 = 123l;

        final float fl = ln1;
        final float fl1 = 123456f;

        final double db = fl1;
        final double db1 = 123123d;

        final boolean b1 = true;
        final char ch1 = 'c';

        System.out.println("Byte: " + b);
        System.out.println("Short: " + sh);
        System.out.println("Short: " + sh1);
        System.out.println("Int: " + in);
        System.out.println("Long: " + ln);
        System.out.println("Long1: " + ln1);
        System.out.println("Float: " + fl);
        System.out.println("Float1: " + fl1);
        System.out.println("Double: " + db);
        System.out.println("Double1: " + db1);
        System.out.println("Boolean: " + b1);
        System.out.println("Char: " + ch1);


    }

}
