package amar.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kumarao on 19-01-2016.
 */
public class FileReaderTest {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/res/amar.txt");
        InputStreamReader inputStreamReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String readLine = bufferedReader.readLine();
        System.out.println(readLine);
    }
}
