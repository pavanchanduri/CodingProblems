package Practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Practice {

    public static void main(String[] args) {
        String[] strList = {"eat", "tea", "tan", "ate", "nat", "bat", "cat", "act"};
        List<List<String>> anagramsBucket = groupAnagrams(strList);
        System.out.println(anagramsBucket);

    }

    private static List<List<String>> groupAnagrams(String[] strList) {

        Map<String, List<String>> freqStringMap = new HashMap<>();
        for(int i=0;i<strList.length;i++) {
            String freqString = generateFrequencyString(strList[i]);
            if(freqStringMap.containsKey(freqString)) {
                freqStringMap.get(freqString).add(strList[i]);
            } else {
                List<String> str = new ArrayList<>();
                str.add(strList[i]);
                freqStringMap.put(freqString, str);
            }
        }
        return new ArrayList<>(freqStringMap.values());
    }

    private static String generateFrequencyString(String str) {
        int[] count = new int[26];
        StringBuilder frequencyString = new StringBuilder();
        for(char c: str.toLowerCase().toCharArray()) {
            count[c-'a']++;
        }

        for(int i=0;i<count.length;i++) {
            if(count[i]>=1) {
                frequencyString.append(count[i]).append((char)(i+'a'));
            }
        }
        return frequencyString.toString();
    }
}
