package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {

    public static void main(String[] args) {

        int[] arr = {1,3,0,5,-2};
        int k = 3, count = 0;
        Map<Integer,Integer> map = new HashMap<>();

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for(int i=1;i<arr.length;i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i=0;i<prefixSum.length;i++) {
            if(prefixSum[i] == k) {
                count++;
            }

            int target = prefixSum[i] - k;
            if(map.containsKey(target)) {
                count += map.get(target);
            }

            if(map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], map.get(prefixSum[i]) + 1);
            } else {
                map.put(prefixSum[i], 1);
            }
        }
        System.out.println(count);
    }
}
