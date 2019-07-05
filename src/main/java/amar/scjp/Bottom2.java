package amar.scjp;

/**
 * Created by amarendra on 22/04/16.
 */
public class Bottom2 extends Clidder {
    public static void main(final String[] args) {
        new Bottom2().flipper();
    }

    public final void flipper() {
        System.out.println("Clidlet");
    }
}

class Clidder {
    private final void flipper() {
        System.out.println("Clidder");
    }
}

