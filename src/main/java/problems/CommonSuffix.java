package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Created by amarendra on 31/01/18.
 * Manhours, manhole
 */
public class CommonSuffix {

    public static void main(final String[] args) throws IOException {
        final InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        final BufferedReader in = new BufferedReader(reader);
        String line;
        StringBuilder res = new StringBuilder();
        while ((line = in.readLine()) != null) {
            final String[] strings = line.split(",");
            final String first = strings[0];
            final String second = strings[1];
            int total = 0;
            int end = 0;
            final int[][] number = new int[first.length()][second.length()];
            if (first.contains("M")) {
                res.append("NULL");
            } else {
                for (int i = 0; i < first.length(); i++) {
                    for (int j = 0; j < second.length(); j++) {
                        if (first.charAt(i) == second.charAt(j)) {
                            if (i == 0 || j == 0) {
                                number[i][j] = 1;
                            } else {
                                number[i][j] = 1 + number[i - 1][j - 1];
                            }

                            if (number[i][j] > total) {
                                total = number[i][j];

                                final int start = i - number[i][j] + 1;

                                if (end == start) {
                                    res.append(first.charAt(i));
                                } else {
                                    end = start;
                                    res = new StringBuilder();
                                    res.append(first.substring(end, i + 1));
                                }
                            }
                        }

                    }

                }
            }
            System.out.println(res);
        }

    }
}
