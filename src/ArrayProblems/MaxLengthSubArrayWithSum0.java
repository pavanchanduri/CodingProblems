package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MaxLengthSubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {1, 0, -4, 3, 1, 0};
        System.out.println(maxLen(arr));
    }

    /**
     * Given an array of integers, find the maximum length of a subarray with a sum of 0.
     * 
     * The algorithm works as follows:
     * 1. Calculate the prefix sum for each index in the array.
     * 2. Use a HashMap to store the first occurrence of each prefix sum.
     * 3. If a prefix sum is found again, it indicates that the subarray between the two indices has a sum of 0.
     * 4. Keep track of the maximum length of such subarrays.
     * 
     * @param arr the input array of integers
     * @return the maximum length of a subarray with sum 0
     */
    private static int maxLen(int[] arr) {

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int maxLength = 0;
        int length = 0;

        for(int i=1;i<arr.length;i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        // If the sum is 0 at any index, we can consider the subarray from the start to that index.
        // This is important because it allows us to count subarrays that start from index 0
        // and have a sum of 0.
        // For example, if the prefix sum at index 3 is 0, it means
        // the subarray from index 0 to index 3 has a sum of 0
        // and we can consider this subarray in our calculations.
        // This is why we check for prefixSum[i] == 0 and update the length
        // accordingly.
        for(int i=0;i<prefixSum.length;i++) {
            if(prefixSum[i]==0) {
                length = i+1;
            }
            maxLength = Math.max(length, maxLength);
        }

        // Now we check for the prefix sums in the map.
        // If a prefix sum is found again, it indicates that the subarray
        // between the two indices has a sum of 0.
        // We update the map with the first occurrence of the prefix sum
        // and calculate the length of the subarray.
        // The length is calculated as the difference between the current index
        // and the first occurrence of the prefix sum.
        // We keep track of the maximum length of such subarrays.
        // This is important because it allows us to find the longest subarray
        // with a sum of 0, even if it starts from an index other than 0.
        // For example, if the prefix sum at index 5 is the same as
        // the prefix sum at index 2, it means the subarray from index 3
        // to index 5 has a sum of 0, and we can consider this subarray
        // in our calculations.
        // This is why we check for prefixSum[i] in the map and update the length
        // accordingly.
        // If the prefix sum is not found in the map, we add it with the current
        // index as both the first and last occurrence.
        // This allows us to keep track of the first occurrence of the prefix sum
        // and calculate the length of the subarray correctly.
        // If the prefix sum is found in the map, we update the last occurrence
        // of the prefix sum to the current index.
        // This allows us to keep track of the longest subarray with a sum of 0
        // and calculate the length correctly.
        // The final result is the maximum length of such subarrays.
        // This is why we return maxLength at the end of the method.
        map.put(0, Arrays.asList(-1,-1)); // To handle the case where the prefix sum is 0 at the start of the array
        length = 0; // Reset length to 0 before checking the map
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
