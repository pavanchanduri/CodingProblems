package Strings;

import java.util.Scanner;

public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
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
