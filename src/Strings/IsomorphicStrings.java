package Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character, but a character may map to itself.
 * Input: s = "egg", t = "add"
 * Output: true
 * Explanation:
 * The strings s and t can be made identical by:
 * Mapping 'e' to 'a'.
 * Mapping 'g' to 'd'.
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String str1 = "badc";
        String str2 = "baba";

        System.out.println(isIsomorphic(str1, str2));
    }

    private static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> hm = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            if(hm.containsKey(s.charAt(i))) {
                if(hm.get(s.charAt(i))!=t.charAt(i)) {
                    return false;
                }
            } else {
                for(Map.Entry<Character, Character> entry: hm.entrySet()) {
                    if(entry.getValue() == t.charAt(i)) {
                        return false;
                    }
                }
                hm.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
