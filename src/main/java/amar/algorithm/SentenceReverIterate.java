package amar.algorithm;

/**
 * Created by amarendrakumar on 03/06/17.
 */
public class SentenceReverIterate {

    public static void main(String[] args) {

        //String sentence="I.love.India";
        StringBuilder sb = new StringBuilder();
        String[] split = args[0].split("\\.");

        for (int i = split.length-1; i >= 0; i--) {
            sb.append(split[i]).append(".");

        }
        String substring = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(substring);




    }
}
