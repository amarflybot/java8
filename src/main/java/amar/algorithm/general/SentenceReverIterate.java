package amar.algorithm.general;

/**
 * Created by amarendrakumar on 03/06/17.
 */
public class SentenceReverIterate {

    public static void main(final String[] args) {

        //String sentence="I.love.India";
        final StringBuilder sb = new StringBuilder();
        final String[] split = args[0].split("\\.");

        for (int i = split.length - 1; i >= 0; i--) {
            sb.append(split[i]).append(".");

        }
        final String substring = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(substring);


    }
}
