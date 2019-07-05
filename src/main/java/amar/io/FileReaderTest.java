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

    public static void main(final String[] args) throws IOException {
        final File file = new File("src/main/res/amar.txt");
        final InputStreamReader inputStreamReader = new FileReader(file);
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        final String readLine = bufferedReader.readLine();
        System.out.println(readLine);
    }
}
