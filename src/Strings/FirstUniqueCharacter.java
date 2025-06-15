package Strings;

import java.util.HashMap;
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
        int index = -1;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            charFreqMap.put(str.charAt(i), charFreqMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (charFreqMap.get(str.charAt(i)) == 1) {
                index = i;
                break;
            }
        System.out.println(index);
        scanner.close();
    }
}
}
