package ArrayProblems;

import java.util.Arrays;

/**
 1. Find the pivot element in the permutation where the element from right is less than the previous element
    i.e., if Input = {1,2,5,4,3} -> Pivot is 2 as it is less than 5
 2. Now, the pivot element has to be swapped with the right next max element as that is the next lexicographically
    i.e., 2 has to be swapped with 3
 3. Now once the swap is done, i.e., {1,3,5,4,2}, the elements after the pivot come in decreasing order which must
    be arranged in sorted order i.e., reversed thereby giving {1,3,2,4,5} which happens to be the next permutation
    of {1,2,5,4,3}
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int pivotIndex = -1;
        for(int i=nums.length-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                pivotIndex = i;
                break;
            }
        }

        if(pivotIndex == -1) {
            Arrays.sort(nums);
            return;
        }

        //Swap the pivot element with the smallest element greater than pivot on its right side
        for(int i=nums.length-1;i>pivotIndex;i--) {
            if(nums[i]>nums[pivotIndex]) {
                int temp = nums[pivotIndex];
                nums[pivotIndex] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        //Reverse the elements from pivot+1 till last index
        int left = pivotIndex+1, right = nums.length-1;
        while(left<=right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
