package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 1. Based on the string, generate a frequency string E.g., a1b2c3......
 2. Group strings based on the frequency string in to a map
 */
public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat", "cat", "act"};

        List<List<String>> anagramList = groupAnagrams(strList);
        for (List<String> anagram : anagramList) {
            System.out.println(anagram);
        }
    }

    /**
     * This method groups anagrams from a list of strings.
     * It generates a frequency string for each string and uses it as a key in a map
     * to group anagrams together.
     * The algorithm works as follows:
     * 1. Initialize a map to hold frequency strings as keys and lists of anagrams
     *    as values.
     * 2. For each string in the input array, generate its frequency string.
     * 3. Check if the frequency string already exists in the map.
     *    - If it does, add the string to the corresponding list.
     *    - If it doesn't, create a new list, add the string to it, and put it in the map.
     * 4. Finally, return the values of the map as a list of lists,
     *    where each inner list contains anagrams that share the same frequency string.
     *
     * @param strList Array of strings to be grouped into anagrams
     * @return List of lists, where each inner list contains anagrams
     */
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

    /**
     * This method generates a frequency string for a given string.
     * The frequency string consists of characters followed by their counts.
     * For example, for the string "aabbcc", the frequency string would be "a2b2c2".
     * It counts the occurrences of each character in the string
     * and constructs the frequency string accordingly.
     * The algorithm works as follows:
     * 1. Initialize an array to count the frequency of each character (assuming lowercase letters
     *    a-z).
     * 2. Iterate through each character in the string and update the frequency array.
     * 3. Construct the frequency string by appending each character and its count.
     * 4. Return the constructed frequency string.
     *
     * @param str The input string for which to generate the frequency string
     * @return The generated frequency string
     */
    private static String generateFrequencyString(String str) {

        int[] freq = new int[26];

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder frequencyString = new StringBuilder();
        for (int i: freq) {
            frequencyString.append((char)i+'a');
            frequencyString.append(i);
        }
        return frequencyString.toString();
    }
}
