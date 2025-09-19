package Strings;

import java.util.HashMap;
import java.util.Map;

public class Equal012Substrings {
    public static int countEqual012Substrings(String s) {
        int count0 = 0, count1 = 0, count2 = 0;
        int result = 0;
        Map<String, Integer> map = new HashMap<>();
        // Initial state: difference is (0,0)
        map.put("0#0", 1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') count0++;
            else if (ch == '1') count1++;
            else if (ch == '2') count2++;

            // Use differences as key
            String key = (count1 - count0) + "#" + (count2 - count1);
            result += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "012012";
        System.out.println(countEqual012Substrings(s)); // Output: 7
    }
}
