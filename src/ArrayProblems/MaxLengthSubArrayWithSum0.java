package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaxLengthSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {1, 0, -4, 3, 1, 0};
        System.out.println(maxLen(arr));
    }

    private static int maxLen(int[] arr) {

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxLength = 0;
        int length = 0;

        for(int i=1;i<arr.length;i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i=0;i<prefixSum.length;i++) {
            if(prefixSum[i]==0) {
                length = i+1;
            }
        }

        maxLength = Math.max(length, maxLength);

        for(int i=0;i<prefixSum.length;i++) {
            if(map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], Arrays.asList(map.get(prefixSum[i]).get(0), i));
            } else {
                map.put(prefixSum[i], Arrays.asList(i,i));
            }
            length = map.get(prefixSum[i]).get(map.get(prefixSum[i]).size()-1)-map.get(prefixSum[i]).get(0);
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
