package Strings;

import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        if(checkAnagrams(str1, str2)) {
            System.out.println("Anagrams");
        } else {
            System.out.println("Not Anagrams");
        }
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
     * 1. Convert both strings to lowercase and remove leading, trailing, and in-between spaces.
     * 2. If the lengths of the two strings are not equal, they cannot be anagrams.
     * 3. Create a count array of size 256 (for each character in the ASCII table).
     * 4. For each character in the first string, increment the corresponding index in the count array.
     * 5. For each character in the second string, decrement the corresponding index in the count array.
     * 6. If all values in the count array are zero, the strings are anagrams; otherwise, they are not.
     * 
     * @param str1 The first string to compare.
     * @param str2 The second string to compare.
     * @return true if the strings are anagrams, false otherwise.
     */
    public static boolean checkAnagrams(String str1, String str2) {

        //Convert strings to lowercase, trim trailing and leading spaces and remove all spaces in between
        str1 = str1.toLowerCase().trim().replaceAll(" ", "");
        str2 = str2.toLowerCase().trim().replaceAll(" ", "");

        if(str1.equals(str2)) {
            return true;
        } else if(str1.length()!=str2.length()) {
            return false;
        }

        //bucket array to store the counts corresponding to each character in the string
        int[] counts = new int[256];

        for(char c: str1.toCharArray()) {
            counts[c]++;
        }
        for(char c: str2.toCharArray()) {
            counts[c]--;
        }

        for(int count:counts) {
            if(count!=0) {
                return false;
            }
        }
        return true;
    }
}
