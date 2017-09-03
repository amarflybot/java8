package amar.algorithm.pattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amarendra on 02/09/17.
 * Program that receives a number and prints it out in large size
 *
 *  0194
 *

        ###  #  ### # #
        # # ##  # # # #
        # #  #  ### ###
        # #  #    #   #
        ### ### ###   #

 */
public class PrintNumbers {

    public static void main(String[] args) {

        String[] zero = {"####", //H=0
                         "#  #", //H=1
                         "#  #", //H=2
                         "#  #", //H=3
                         "####"}; //H=4
        String[] one = {"   # ",
                        "  ## ",
                        "   # ",
                        "   # ",
                        " ####"};

        String[] nine = {" ####",
                         " #  #",
                         " ####",
                         "    #",
                         " ####"};

        String[] four = {" #  #",
                         " #  #",
                         " ####",
                         "    #",
                         "    #"};

        String digit = "0194";

        Map<String, String[]> map = new HashMap<>();
        map.put("0", zero);
        map.put("1", one);
        map.put("9", nine);
        map.put("4", four);
        int h = 0;
        while (h<5) {

            for (int i = 0; i < digit.length(); i++) {
                String string = String.valueOf(digit.charAt(i));
                final String[] obj = map.get(string);
                System.out.print(obj[h]);
            }
            h++;
            System.out.println("");
        }


    }

}