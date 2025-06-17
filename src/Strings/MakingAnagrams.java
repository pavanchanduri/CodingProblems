package Strings;

import java.util.Scanner;

/**
1. Create a bucket array of 26 characters
2. Iterate through the first string and add frequency count character wise in to the array
3. Iterate through the second string and subtract the frequency count character wise from the array
4. Iterate through the bucket array and find the number of characters to be removed to make the strings anagrams
 */
public class MakingAnagrams {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();
        makingAnagrams(str1, str2);
        
    }

    /**
     * This method calculates the number of characters that need to be removed
     * from two strings to make them anagrams of each other.
     * It uses a bucket array to count the frequency of each character in both strings,
     * and then calculates the total number of characters that need to be removed.
     * 
     * The algorithm works as follows:
     * 1. Create a bucket array of size 26 to represent the frequency of each
     *    character (assuming only lowercase letters a-z).
     * 2. Iterate through the first string and increment the count for each character in the
     *    bucket array.
     * 3. Iterate through the second string and decrement the count for each character in the
     *    bucket array.
     * 4. Finally, iterate through the bucket array and sum the absolute values of the counts
     *    to get the total number of characters that need to be removed.
     *
     * @param str1 The first input string
     * @param str2 The second input string
     */
    private static void makingAnagrams(String str1, String str2) {
        int[] bucket = new int[26];
        for (char c : str1.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            bucket[c - 'a']--;
        }
        
        int count = 0;
        for (int freq : bucket) {
            count += Math.abs(freq);
        }
        
        System.out.println("Number of characters to be removed to make the strings anagrams: " + count);
    }
}
