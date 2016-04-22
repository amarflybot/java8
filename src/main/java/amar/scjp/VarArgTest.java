package amar.scjp;

/**
 * Created by amarendra on 21/04/16.
 */
public class VarArgTest {


    public static void main(String[] args) {
        dostuff(5,5);
    }

    private static void dostuff(int x, int... var) {
        System.out.println(var[0]);
        System.out.println(x);
    }
}
