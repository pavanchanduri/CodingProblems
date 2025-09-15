package ArrayProblems;

import java.util.Scanner;

public class SlidingWindowMaxAverageSubArray {

    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.close();

        double maxAvg = findMaxAverageSubArray(arr, k);
        System.out.println("Max Average of Sub Array: " + maxAvg);
    }
    /**
     * This method finds the maximum average of any contiguous subarray of size k.
     * It uses the sliding window technique to efficiently calculate the sum of subarrays.
     * 
     * The algorithm works as follows:
     * 1. Calculate the sum of the first k elements.
     * 2. Initialize maxSum with this initial sum.
     * 3. Slide the window from the start to the end of the array:
     *    - Subtract the element going out of the window (start index).
     *    - Add the element coming into the window (end index).
     *    - Update maxSum if the current sum is greater than maxSum.
     * 4. Finally, return the maximum average by dividing maxSum by k.
     *
     * @param arr The input array
     * @param k The size of the subarray
     * @return The maximum average of any contiguous subarray of size k
     */
    private static double findMaxAverageSubArray(int[] arr, int k) {
        if (arr == null || arr.length < k || k <= 0) return 0;

        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += arr[i];

        int maxSum = sum;
        int startIndex = 0;
        int endIndex = k;

        // Start Sliding window by subtracting the first number in the previous window
        // and adding the new number in the next window
        while (endIndex < arr.length) {
            sum -= arr[startIndex];
            startIndex++;
            sum += arr[endIndex];
            endIndex++;
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum / k;
    }
}