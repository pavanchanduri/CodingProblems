package Strings;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class SentenceSort {

    public static void main(String[] args) {

        String str = "is2 sentence4 This1 a3";
        String[] str2 = str.split(" ");
        sentenceSort(str2);
    }

    /**
     * Sorts sentences based on the last character of each sentence.
     * The last character is expected to be a digit indicating the order.
     * The method uses a TreeMap to maintain the order of sentences based on the digit.
     * 
     * The algorithm works as follows: 
     * 1. Split the input string into an array of sentences.
     * 2. Create a TreeMap to store sentences with their corresponding order.
     * 3. Iterate through the array of sentences, extracting the last character (expected to
     *   be a digit) and the rest of the sentence.
     * 4. Store the sentence in the TreeMap with the digit as the key.
     * 5. Iterate through the TreeMap and append the sentences in order to a String Builder.
     * 
     * @param str2 Array of sentences to be sorted.
     */
    private static void sentenceSort(String[] str2) {
        Map<Integer, String> map = new TreeMap<>(Comparator.naturalOrder());
        for (String s : str2) {
            map.put(Integer.parseInt(s.substring(s.length() - 1)), 
            s.substring(0, s.length() - 1));
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            result.append(entry.getValue()).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}
