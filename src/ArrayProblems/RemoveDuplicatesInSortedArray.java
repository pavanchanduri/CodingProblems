package ArrayProblems;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 5, 6, 6, 7, 8, 8, 9};
        int length = removeDuplicates(nums);

        // Print the unique elements
        System.out.println("Unique elements: " + Arrays.toString(Arrays.copyOf(nums, length)));
    }

    public static int removeDuplicates(int [] nums) {
        if (nums.length == 0) return 0;

        int uniqueIndex = 0; // Points to the position of the last unique element

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        return uniqueIndex + 1; // Length of the array with unique elements
    }
}