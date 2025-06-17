package Strings;

import java.util.Arrays;

/**
 1. Sort the elements
 2. Run a loop and compare characters in the first and last string until the characters are not equal
 3. Keep appending the character to the result until mismatch happens
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] str = {"flower","flow","flight"};
        longestCommonPrefix(str);
    }

    /**
     * This method finds the longest common prefix among an array of strings.
     * It sorts the array and compares the first and last strings to find the common prefix.
     *
     * The algorithm works as follows:
     * 1. Sort the array of strings.
     * 2. Convert the first and last strings to character arrays.
     * 3. Compare characters at each index until a mismatch is found.
     * 4. Append matching characters to a StringBuilder.
     * 5. Print the resulting common prefix.
     *
     * @param str An array of strings
     */
    private static void longestCommonPrefix(String[] str) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(str);

        char[] first = str[0].toCharArray();
        char[] last = str[str.length-1].toCharArray();

        for (int i = 0; i < first.length; i++) {
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);
        }
        System.out.println(result);
    }
}
