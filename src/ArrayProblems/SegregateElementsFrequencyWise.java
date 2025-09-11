package ArrayProblems;

import java.util.*;

public class SegregateElementsFrequencyWise {
    public static void main(String[] args) {
        int[] nums = {4,4,1,2,2,3};
        int[] result = segregate(nums);
        System.out.println(Arrays.toString(result)); // Output: [4, 4, 2, 2, 1, 3]
    }

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