package amar.algorithm.general;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by amarendra on 23/10/17.
 */
public class HighestFrequencyWord {

    public static void main(final String[] args) throws IOException {

        final long time = getTotalTimeOfRun();
        final long time1 = getTotalTimeOfRun();
        final long time2 = getTotalTimeOfRun();


        System.out.println("Total Average Time taken: " + ((time + time1 + time2) / 3));


    }

    public static long getTotalTimeOfRun() throws IOException {
        final Date start = new Date();

        final Map<String, Integer> map = new HashMap<>();

        final BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/amarendra/IdeaProjects/java8/src/main/res/sampleSentence.txt")));

        while (true) {
            final String line = reader.readLine();
            if (line != null) {
                final String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    final String word = words[i];
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                    } else {
                        map.put(word, 1);
                    }
                }
            } else {
                break;
            }
        }
        final List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        final Map.Entry<String, Integer> entry = entries.get(0);
        System.out.println(entry);

        final Date end = new Date();

        return end.getTime() - start.getTime();
    }
}
