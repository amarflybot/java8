package amar.scjp;

/**
 * Created by amarendra on 22/04/16.
 */
public class Bottom2 extends Clidder {
    public final void flipper() { System.out.println("Clidlet");  }
    public static void main(String [] args) {
        new Bottom2().flipper();
    }
}

class Clidder {
    private final void flipper() { System.out.println("Clidder"); }
}
