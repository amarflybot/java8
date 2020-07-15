package problems;

/* IMPORTANT: Multiple classes and nested static classes are supported */

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class CandleProblem {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();                // Reading input from STDIN
        //System.out.println("Hi, " + line + ".");    // Writing output to STDOUT

        final String[] split = line.split(" ");
        Integer sum = Integer.valueOf(split[0]);
        Integer m = Integer.valueOf(split[1]);
        Integer remain = sum;
        while (remain > 0) {
            remain = remain / m;
            sum = sum + remain;
        }

        System.out.println("Numbers of candles: "+ sum);
    }
}
