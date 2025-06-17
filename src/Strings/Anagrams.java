package Strings;

import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        checkAnagrams(str1, str2);
    }

    /**
     * Checks if two strings are anagrams of each other.
     * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * For example, "listen" is an anagram of "silent".
     * This method ignores case and spaces, treating "Listen" and "Silent" as anagrams,
     * as well as "A gentleman" and "Elegant man"
     * 
     * The algorithm works as follows:
     * 1. Convert both strings to lowercase and remove all spaces.
     * 2. If the lengths of the two strings are not equal, they cannot be anagrams, so print "Not Anagrams" and exit.
     * 3. Create a bucket array of size 26 (for each letter in the English alphabet).
     * 4. Iterate through the first string and increment the count for each character in the bucket array.
     * 5. Iterate through the second string and decrement the count for each character in the bucket array.
     * 6. If all counts are zero, the strings are anagrams; otherwise, they are not.
     * 
     * @param str1 The first string to compare.
     * @param str2 The second string to compare.
     */
    public static void checkAnagrams(String str1, String str2) {

        //Convert strings to lowercase, trim trailing and leading spaces and remove all spaces in between
        str1 = str1.toLowerCase().trim().replaceAll(" ", "");
        str2 = str2.toLowerCase().trim().replaceAll(" ", "");

        if(str1.equals(str2)) {
            System.out.println("Anagrams");
            System.exit(0);
        } else if(str1.length()!=str2.length()) {
            System.out.println("Not Anagrams");
            System.exit(0);
        }

        //bucket array to store the counts corresponding to each character in the string
        int[] counts = new int[26];

        for(char c: str1.toCharArray()) {
            counts[c-'a']++;
        }
        for(int i=0;i<str2.length();i++) {
            counts[str2.charAt(i)-'a']--;
        }

        for(int count:counts) {
            if(count!=0) {
                System.out.println("Not Anagrams");
                System.exit(0);
            }
        }
        System.out.println("Anagrams");
    }
}
