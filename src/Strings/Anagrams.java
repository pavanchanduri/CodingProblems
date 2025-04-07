package Strings;

import java.util.Scanner;

/**
1. Create a bucket array of 26 characters
2. Iterate through the first string and add frequency count character wise in to the array
3. Iterate through the second string and subtract the frequency count character wise from the array
4. Iterate through the array and if any count != 0, return false i.e., Strings are not anagrams
 **/
public class Anagrams {

    public static void main(String[] args) {
        String str1 = new Scanner(System.in).nextLine();
        String str2 = new Scanner(System.in).nextLine();

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

        for(int i=0;i<str1.length();i++) {
            counts[str1.charAt(i)-'a']++;
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
