package ArrayProblems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SegregateElementsFrequencyWise {
    public static void main(String[] args) {
        int[] nums = {4,4,1,2,2,3};
        int[] result = segregate(nums);
        System.out.println(Arrays.toString(result)); // Output: [4, 4, 2, 2, 1, 3]
    }

    /**
     * Segregates elements of the array based on their frequency.
     * The algorithm works as follows:
     * 1. Count the frequency of each element using a LinkedHashMap to maintain insertion order.
     * 2. Sort the elements based on their frequency in descending order.
     * 3. Construct the result array by placing elements according to their frequency.
     * 
     * @param nums The input array of integers.
     * @return A new array with elements sorted by frequency.
     */
    private static int[] segregate(int[] nums) {
        Map<Integer, Integer> freq = new LinkedHashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(freq.keySet());
        keys.sort((a, b) -> freq.get(b) - freq.get(a)); // sort by frequency descending

        int[] result = new int[nums.length];
        int index = 0;
        for (int key : keys) {
            for (int i = 0; i < freq.get(key); i++) {
                result[index++] = key;
            }
        }
        return result;
    }
}