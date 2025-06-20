package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithSumK {

    public static void main(String[] args) {

        int[] arr = {1,3,0,5,-2};
        int k = 3;
        System.out.println(subArrayCountWithSumK(arr, k));
    }

    /**
     * This method counts the number of subarrays with a sum equal to k.
     * It uses a prefix sum approach and a HashMap to store the frequency of prefix sums.
     * 
     * The algorithm works as follows:
     * 1. Calculate the prefix sum for each element in the array.
     * 2. For each prefix sum, check if it equals k. If it does, increment the count.
     * 3. Calculate the target sum as the current prefix sum minus k.
     * 4. If the target sum exists in the HashMap, it means there are subarrays that sum to k, so add the frequency of the target sum to the count.
     * 5. Update the HashMap with the current prefix sum, incrementing its frequency if it already exists, or initializing it to 1 if it does not.
     *
     * @param arr The input array
     * @param k The target sum
     * @return The count of subarrays with sum equal to k
     */
    private static int subArrayCountWithSumK(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
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
        return count;
    }
}
