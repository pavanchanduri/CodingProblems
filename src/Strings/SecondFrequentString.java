package Strings;

import java.util.HashMap;
import java.util.Map;

public class SecondFrequentString {

    public static void main(String[] args) {
        String[] arr =  {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        System.out.println(secFrequent(arr, arr.length));
    }

    /**
     * Finds the second most frequent string in an array of strings.
     * This method uses a HashMap to count the frequency of each string
     * and then determines the second highest frequency.
     * 
     * The algorithm works as follows:
     * 1. Create a HashMap to store the frequency of each string.
     * 2. Iterate through the array and populate the HashMap.
     * 3. Find the maximum and second maximum frequencies.
     * 4. Return the string corresponding to the second maximum frequency.
     *
     * @param arr The array of strings.
     * @param N The number of elements in the array.
     * @return The second most frequent string, or an empty string if no such string exists.
     */
    static String secFrequent(String[] arr, int N) {
        // your code here
        Map<String, Integer> hm = new HashMap<>();
        for(int i=0;i<N;i++) {
            if(hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i])+1);
            } else {
                hm.put(arr[i], 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry: hm.entrySet()) {
            if (entry.getValue() > max) {
                secondMax = max;
                max = entry.getValue();
            } else if(entry.getValue()>secondMax && entry.getValue()!=max){
                secondMax = entry.getValue();
            }
        }

        for(Map.Entry<String, Integer> entry: hm.entrySet()) {
            if(entry.getValue() == secondMax) {
                return entry.getKey();
            }
        }
        return "";
    }
}
