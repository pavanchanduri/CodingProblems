package Strings;

import java.util.HashMap;
import java.util.Map;

public class SecondFrequentString {

    public static void main(String[] args) {
        String[] arr =  {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        System.out.println(secFrequent(arr, arr.length));
    }

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
