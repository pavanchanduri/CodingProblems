package Strings;

import java.util.Scanner;

/**
 1. Start with the second character and decrement low and increment high
 2. Keep iterating until low becomes -1 or high reaches end of the string
 3. Store the palindromes at each and every instance and store in LPS
 4. Repeat the above steps considering even length i.e., low = i=1 and high = i
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        longestCommonPalindromicSubString(str);
    }

    /**
     * This method finds the longest palindromic substring in a given string.
     * It uses a two-pointer technique to expand around each character and check for palindromes.
     * 
     * The algorithm works as follows:
     * 1. Initialize an empty string to store the longest palindrome found.
     * 2. Iterate through each character in the string, treating it as the center of a potential palindrome.
     * 3. For each character, expand outwards in both directions (left and right) to find palindromes.
     * 4. If a palindrome is found that is longer than the previously recorded longest palindrome,
     *    update the longest palindrome.
     * 5. Print the longest palindromic substring found.
     *
     * @param str The input string
     */
    private static void longestCommonPalindromicSubString(String str) {
        String longestPalindromeSubString = "";

        if(str.length()<=1) {
            System.out.println(str);
        }

        for(int i=1;i<str.length();i++) {

            //consider odd length sub string
            int low = i;
            int high = i;

            //keep moving in both left and right directions till the characters are not equal
            while(str.charAt(low)==str.charAt(high)) {
                low--;
                high++;

                //terminate the condition if we reach start/end of the string
                if(low == -1 || high == str.length()) {
                    break;
                }
            }

            //use the low and high indexes to fetch the palindrome substring
            String palindrome = str.substring(low+1,high);

            //capture the longest palindrome substring found till now
            if(palindrome.length()>= longestPalindromeSubString.length()) {
                longestPalindromeSubString = palindrome;
            }

            //Consider even length
            low = i-1;
            high = i;

            while(str.charAt(low)==str.charAt(high)) {
                low--;
                high++;

                if(low == -1 || high == str.length()) {
                    break;
                }
            }

            palindrome = str.substring(low+1,high);
            if(palindrome.length()>= longestPalindromeSubString.length()) {
                longestPalindromeSubString = palindrome;
            }
        }
        System.out.println(longestPalindromeSubString);
    }
}
