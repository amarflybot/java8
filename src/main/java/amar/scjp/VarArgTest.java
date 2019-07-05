package amar.scjp;

/**
 * Created by amarendra on 21/04/16.
 */
public class VarArgTest {


    public static void main(final String[] args) {
        dostuff(5, 5);
    }

    private static void dostuff(final int x, final int... var) {
        System.out.println(var[0]);
        System.out.println(x);
    }
}
