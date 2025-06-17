package Strings;

import java.util.ArrayList;
import java.util.List;

public class LargestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s = "pwwkewepweaboi";
        System.out.println(longestSubstringWithoutDuplication(s));
    }


    /**
     * This method finds the longest substring without repeating characters.
     * It uses a sliding window approach with a list to keep track of characters in the current substring.
     * 
     * The algorithm works as follows:
     * 1. Initialize two pointers: start and end to represent the current substring.
     * 2. Use a list to keep track of characters in the current substring.
     * 3. Iterate through the string with the end pointer.
     * 4. If the current character is already in the list, remove characters from the
     *    start of the list until the current character can be added without duplication.
     * 5. Add the current character to the list.
     * 6. Update the maximum length and the longest substring if the current substring is longer
     *    than the previously recorded maximum length.
     * 7. Return the longest substring found.
     * 
     * @param s The input string
     * @return The longest substring without repeating characters
     */
    private static String longestSubstringWithoutDuplication(String s) {
        int n = s.length();
        int start = 0, maxLength = 0;
        String longestSubstring = "";
        List<Character> charSet = new ArrayList<>();

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            while (charSet.contains(currentChar)) {
                charSet.remove(0); // Remove the first character until no duplicates
                start++;
            }
            charSet.add(currentChar);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                longestSubstring = s.substring(start, end + 1);
            }
        }
        return longestSubstring;
    }
}
