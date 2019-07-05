package amar.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amarendra on 16/02/16.
 */
public class MapUtil {

    public static void main(final String[] args) {

        final Map<String, String> testMap = new HashMap<>();
        testMap.put("Amar", "Zasw");
        testMap.put("Aaaa", "Yqwer");
        testMap.put("Aerw", "Wqwer");

        System.out.println(testMap);

        final Map<String, String> sortedMap = sortByValues(testMap);

        System.out.println(sortedMap);
    }

    private static Map<String, String> sortByValues(final Map<String, String> testMap) {
        final List<Map.Entry<String, String>> entries = new ArrayList<>(testMap.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(final Map.Entry<String, String> o1, final Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        final Map<String, String> result = new LinkedHashMap<>();

        for (final Map.Entry<String, String> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
