package amar.algorithm.general;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by amarendrakumar on 02/06/17.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String fileName = "/Volumes/win2/sandbox/java8/src/main/res/Output003.txt";
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = findNumber(_arr, _k);
        bw.write(res);
        bw.newLine();

        bw.close();
    }

    private static String findNumber(int[] arr, int k) {
        int length = arr.length;
        int searchableLength = arr[0];
        for(int i = 0; i < arr.length; i++)
        {
            if (k==arr[i]){
                return "YES";
            }
        }

        return "NO";
    }
}
