package Strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 1. Create a character frequency map storing the character as key and frequency as value
 2. Iterate over the string and if the frequency from the map is 1, return the index
 */
public class FirstUniqueCharacter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        System.out.println(firstUniqueCharacter(str));
    }

    /**
     * Finds the index of the first unique character in a string.  
     * This method uses a frequency map to count occurrences of each character,
     * and then identifies the first character with a count of 1.
     * 
     * The algorithm works as follows:
     * 1. Create a frequency map to count occurrences of each character.
     * 2. Iterate through the string and populate the frequency map.
     * 3. Iterate through the string again and check the frequency map.
     *    If the frequency of a character is 1, return its index.
     * 4. If no unique character is found, return -1.
     * 
     * @param str The input string to search for the first unique character.
     * @return The index of the first unique character, or -1 if none exists.
     */
    public static int firstUniqueCharacter(String str) {
        Map<Character, Integer> frequencyMap = new LinkedHashMap<>();

        // Step 1: Create frequency map
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Find the first unique character
        for (int i = 0; i < str.length(); i++) {
            if (frequencyMap.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // If no unique character found
    }
}
