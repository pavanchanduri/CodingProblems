package ArrayProblems;

import java.util.HashMap;

public class MaxLengthSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 0, -4, 3, 1, -1, 1};
        int k = 0;
        System.out.println(maxLengthSubArray(arr,k));
    }

    /**
     * Given an array of integers, find the maximum length of a subarray with a sum of k.
     *
     * The algorithm works as follows:
     * 1. Initialize a HashMap to store the prefix sums and their first occurrence indices.
     * 2. Iterate through the array, maintaining a running prefix sum.
     * 3. For each element, check if the current prefix sum equals k. If it does, update the maximum length.
     * 4. Check if there exists a prefix sum such that when subtracted from the current prefix sum equals k.
     * 5. If such a prefix sum exists, calculate the length of the subarray and update the maximum length if it's greater than the current maximum.
     * 6. Store the first occurrence of the prefix sum in the HashMap if it does not already exist.
     * 
     * @param arr the input array of integers
     * @return the maximum length of a subarray with sum k
     */
    private static int maxLengthSubArray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Check if the current prefix sum is equal to k
            if (prefixSum == k) {
                maxLength = i + 1; // Update maxLength if the subarray from start to i has sum k
            }

            // Idea here is that if there exists a prefix sum such that prefixSum - k = previousPrefixSum,
            // then the subarray from the index of previousPrefixSum + 1 to i has sum k.
            // Check if there exists a prefix sum such that prefixSum - k = previousPrefixSum
            // If it exists, calculate the length of the subarray and update maxLength if it's greater
            // than the current maxLength.
            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }

            // Store the first occurrence of the prefix sum
            // We only store the first occurrence to maximize the length of the subarray
            // If the prefix sum already exists, we do not update it to ensure we get the longest subarray
            // with the same prefix sum.
            // This is crucial because if we update it, we might miss a longer subarray that could have been formed
            // with the earlier occurrence of the same prefix sum.
            // This way, we ensure that we always have the earliest index for each prefix sum.
            // This is important to ensure we get the longest subarray with the same prefix sum.
            if (map.containsKey(prefixSum)) {
                continue;
            }
            map.put(prefixSum, i);
        }
        return maxLength;
    }
}
