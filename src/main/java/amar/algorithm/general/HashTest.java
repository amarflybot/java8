package amar.algorithm.general;

/**
 * Created by amarendra on 03/09/17.
 */
public class HashTest {

    public static void main(final String[] args) {

        final String str = "zeebra";

        final int hashCode = str.hashCode();
        final int hash = ((hashCode) ^ (hashCode >>> 16)) % 16;

        System.out.println(hash);

    }

    static final int hash(final Object key) {
        final int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
