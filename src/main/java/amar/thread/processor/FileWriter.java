package amar.thread.processor;

import org.fluttercode.datafactory.impl.DataFactory;

import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Created by amarendra on 23/10/17.
 */
public class FileWriter {

    public static void main(final String[] args) throws IOException {

        final java.io.FileWriter writer = new java.io.FileWriter("/Users/amarendra/IdeaProjects/java8/src/main/res/sampleSentence.txt");
        final BufferedWriter bufferedWriter = new BufferedWriter(writer);
        final DataFactory factory = new DataFactory();

        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10; j++) {

                bufferedWriter.write(" Line " + factory.getRandomWord());
            }

            bufferedWriter.write(".\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
        writer.close();

    }
}
