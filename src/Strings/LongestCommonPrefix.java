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
