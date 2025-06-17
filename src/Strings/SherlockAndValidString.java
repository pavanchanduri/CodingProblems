package Strings;

import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

public class SherlockAndValidString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        isValid(str);
    }

    /**
     * Checks if the given string is valid according to the rules of character frequency.
     * A string is valid if:
     * 1. All characters have the same frequency.
     * 2. At most one character can have a frequency that is one more than the others.
     * 3. At most one character can have a frequency of 1.
     * 
     * The algorithm works as follows:
     * 1. Count the frequency of each character in the string using a HashMap.
     * 2. Store the frequencies in a list and sort it.
     * 3. Check the conditions for validity:
     *   - If all characters have the same frequency.
     *   - If there is one character with a frequency of 1 and the rest have the same frequency.
     *   - If there is one character with a frequency that is one more than the rest.
     * 4. Print "True" if the string is valid, otherwise print "False".
     *
     * @param str The input string to check for validity.
     */
    private static void isValid(String str) {
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            charFreqMap.put(letter, charFreqMap.getOrDefault(letter, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry: charFreqMap.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);

        if(charFreqMap.size() == 1) {
            System.out.println("True");
            System.exit(0);
        }

        int first = list.get(0);
        int second = list.get(1);
        int secondLast = list.get(list.size()-2);
        int last = list.get(list.size()-1);

        if(first == last) {
            System.out.println("True");
        } else if(first == second && second == secondLast && secondLast == (last - 1)) {
            System.out.println("True");
        } else if (first == 1 && second == last) {
            System.out.println("True");
        }else if(first == second -1 && second == last) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
