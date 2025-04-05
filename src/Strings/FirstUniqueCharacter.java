package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstUniqueCharacter {

    public static void main(String[] args) {

        String str = new Scanner(System.in).nextLine();
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
        }
        System.out.println(index);
    }
}
