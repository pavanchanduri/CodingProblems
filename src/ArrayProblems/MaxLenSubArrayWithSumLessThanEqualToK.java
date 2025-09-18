package ArrayProblems;

public class MaxLenSubArrayWithSumLessThanEqualToK {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 9;
        int maxLength = findMaxLenSubArray(arr, k);
        System.out.println("Maximum length of subarray with sum less than or equal to " + k + " is: " + maxLength);
    }

    /**
     * Find the maximum length subarray with sum less than or equal to k
     * The algorithm works as follows:
     * 1. Use two pointers (start and end) to represent the current subarray.
     * 2. Expand the end pointer to include more elements and update the current sum.
     * 3. If the current sum exceeds k, move the start pointer to reduce the sum.
     * 4. Keep track of the maximum length of valid subarrays found during the process.
     * 5. Return the maximum length found.
     * 
     * @param nums input array of integers
     * @param k the maximum allowed sum for the subarray
     * @return the length of the longest subarray with sum less than or equal to k
     */
    private static int findMaxLenSubArray(int[] nums, int k) {
        int currSum = 0;
        int end=0;int start=0;
        int maxLength = 0;
        
        while(end<nums.length) {
            currSum = currSum+nums[end];
            end++;
            while(currSum>k && start<end) {
                currSum = currSum-nums[start];
                start++;
            }
            maxLength = Math.max(end-start, maxLength);
        }
        
        return maxLength;  
    }
}