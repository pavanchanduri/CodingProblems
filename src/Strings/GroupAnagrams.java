package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat", "cat", "act"};

        List<List<String>> anagramList = groupAnagrams(strList);
        for (List<String> anagram : anagramList) {
            System.out.println(anagram);
        }
    }

    private static List<List<String>> groupAnagrams(String[] strList) {

        if(strList == null || strList.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringsMap = new HashMap<>();
        for (String str : strList) {
            String frequencyString = generateFrequencyString(str);

            if(frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                frequencyStringsMap.put(frequencyString, list);
            }
        }
        return new ArrayList<>(frequencyStringsMap.values());
    }

    private static String generateFrequencyString(String str) {

        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        char ch = 'a';
        StringBuilder frequencyString = new StringBuilder();
        for (int i: freq) {
            frequencyString.append(ch);
            frequencyString.append(i);
            ch++;
        }
        return frequencyString.toString();
    }
}
