package ArrayProblems;

public class MaxSumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }


    /**
     * Kadane's Algorithm
     * 
     * The algorithm works as follows:
     * 1. Initialize two variables, leftSum and rightSum, to keep track of
     *    the maximum subarray sum from the left and right sides of the array.
     * 2. Iterate through the array from both ends, updating leftSum and rightSum
     *    as you go.
     * 3. If either leftSum or rightSum becomes zero or negative, reset it
     *    to the current element, so that the new sum starts from the next element.
     * 4. Keep track of the maximum sum encountered so far.
     * 5. Return the maximum sum found.
     * 
     * @param nums the input array of integers
     * @return the maximum subarray sum
     */
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {

            leftSum = leftSum <= 0 ? nums[i] : leftSum + nums[i];
            rightSum = rightSum <= 0 ? nums[n-1-i] : rightSum + nums[n-1-i];
            maxSum = Math.max(maxSum, Math.max(leftSum, rightSum));
        }
        return maxSum;
    }
}
