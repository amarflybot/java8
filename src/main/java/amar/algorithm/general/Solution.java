package amar.algorithm.general;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by amarendrakumar on 02/06/17.
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        String fileName = "/Volumes/win2/sandbox/java8/src/main/res/Output003.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int[] res;
        int _l;
        _l = Integer.parseInt(in.nextLine().trim());

        int _r;
        _r = Integer.parseInt(in.nextLine().trim());

        res = oddNumbers(_l, _r);
        for(int res_i=0; res_i < res.length; res_i++) {
            bw.write(String.valueOf(res[res_i]));
            bw.newLine();
        }

        bw.close();
    }

    private static int[] oddNumbers(int l, int r) {
        int max = (r - l)/2 + 1;
        int[] arr = new int[max];
        int j=0;
        if (l % 2 == 0){
            l=l+1;
            for (int i = l; i <= r; i=i+2) {
                arr[j] = l;
                l=l+2;
                j++;
            }
        } else {
            for (int i = l; i <= r; i=i+2) {
                arr[j] = l;
                l=l+2;
                j++;
            }
        }
        return arr;
    }
}
