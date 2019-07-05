package amar.code.greater_good;

public class Timeit {
    public static void code(final Runnable block) {
        final long start = System.nanoTime();
        try {
            block.run();
        } finally {
            final long end = System.nanoTime();
            System.out.println("Time taken(s): " + (end - start) / 1.0e9);
        }
    }
}
