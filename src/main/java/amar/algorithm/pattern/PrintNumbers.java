package amar.algorithm.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 02/09/17.
 * Program that receives a number and prints it out in large size
 * <p>
 * 0194
 * <p>
 * <p>
 * ###  #  ### # #
 * # # ##  # # # #
 * # #  #  ### ###
 * # #  #    #   #
 * ### ### ###   #
 */
public class PrintNumbers {

    public static void main(final String[] args) {

        final String[] zero = {"####", //H=0
                "#  #", //H=1
                "#  #", //H=2
                "#  #", //H=3
                "####"}; //H=4
        final String[] one = {"   # ",
                "  ## ",
                "   # ",
                "   # ",
                " ####"};

        final String[] nine = {" ####",
                " #  #",
                " ####",
                "    #",
                " ####"};

        final String[] four = {" #  #",
                " #  #",
                " ####",
                "    #",
                "    #"};

        final String digit = "0194";

        final Map<String, String[]> map = new HashMap<>();
        map.put("0", zero);
        map.put("1", one);
        map.put("9", nine);
        map.put("4", four);
        int h = 0;
        while (h < 5) {

            for (int i = 0; i < digit.length(); i++) {
                final String string = String.valueOf(digit.charAt(i));
                final String[] obj = map.get(string);
                System.out.print(obj[h]);
            }
            h++;
            System.out.println("");
        }


    }

}
