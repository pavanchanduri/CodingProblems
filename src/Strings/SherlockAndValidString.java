package Strings;

import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

public class SherlockAndValidString {

    //Deals with string where frequencies of all characters are same
    //You can have at most one character with a frequency 1 more than the rest which can be removed
    //Also you can have one character with 1 as the frequency which can be removed
    public static void main(String[] args) {

        String str = new Scanner(System.in).nextLine();
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

        int first = list.getFirst();
        int second = list.get(1);
        int secondLast = list.get(list.size()-2);
        int last = list.getLast();

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
