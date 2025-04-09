package Strings;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 1. Extract the number from each of the sub strings and store them in a TreeMap
 2. TreeMap stores keys by default in their ascending order
 3. Iterate the map and build the string using the corresponding values
 */
public class SentenceSort {

    public static void main(String[] args) {

        String str = "is2 sentence4 This1 a3";
        String[] str2 = str.split(" ");

        Map<Integer, String> map = new TreeMap<>(Comparator.naturalOrder());
        for (String s : str2) {
            map.put(Integer.parseInt(s.substring(s.length() - 1)), s.substring(0, s.length() - 1));
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.append(entry.getValue()).append(" ");
        }
        System.out.println(result);
    }
}
