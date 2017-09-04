package amar.algorithm.general;

/**
 * Created by amarendra on 03/09/17.
 */
public class HashTest {

    public static void main(String[] args) {

        String str = "zeebra";

        int hashCode = str.hashCode();
        int hash = ((hashCode) ^ (hashCode >>> 16))%16;

        System.out.println(hash);

    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
