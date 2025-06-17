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

    /**
     * This method checks if two strings are isomorphic.
     * Two strings are isomorphic if the characters in one string can be replaced to get the
     * other string, while preserving the order of characters.
     * 
     * The algorithm works as follows:
     * 1. Initialize a HashMap to store character mappings.
     * 2. Iterate through the characters of both strings simultaneously.
     * 3. For each character in the first string, check if it is already mapped
     *    to a character in the second string.
     *    - If it is, verify that the mapping matches the current character in the second
     *      string. If not, return false.
     *    - If it is not mapped, check if the current character in the second string
     *      is already mapped to another character in the first string. If it is, return false.
     * 4. If all characters can be mapped correctly, return true.
     * 
     * @param s the first string
     * @param t the second string
     * @return true if the strings are isomorphic, false otherwise
     */
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
