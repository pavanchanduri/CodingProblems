package MiscProblems;

/*
1. Take two pointer approach and iterative over the array from both sides
2. If any sum becomes zero or negative, make the sum equivalent to the nums[i] so that the new sum gets computed
   from the next element onwards.
3. Pick the maximum sum among existing sum and max of leftSum and rightSum
 */
public class MaxSumSubArray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int leftSum = nums[0];
        int rightSum = nums[n-1];
        int maxSum = nums[0];

        for(int i=1;i<n;i++) {

            if(leftSum <= 0) {
                leftSum = nums[i];
            } else {
                leftSum += nums[i];
            }

            if(rightSum <= 0) {
                rightSum = nums[n-i-1];
            } else {
                rightSum+= nums[n-i-1];
            }

            maxSum = Math.max(maxSum, Math.max(leftSum, rightSum));
        }
        return maxSum;
    }
}
