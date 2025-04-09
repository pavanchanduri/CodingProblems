package Arrays;

import java.util.Scanner;

/**
1. First find the sum until kth window i.e., index 0 to k-1 and store the sum as maxSum
2. Now mark the end index as k and run a loop till the endIndex becomes arr.length-1
3. In the loop, subtract the element used with startIndex from the sum i.e., 0 and increment it
4. Now add the endIndex element i.e., arr[k] to the sum and increment the endIndex
5. Keep storing maxSum in each iteration of the loop.
 */
public class SlidingWindowMaxAverageSubArray {

    public static void main(String[] args) {

        int[] arr = {1,12,-5,-6,50,3};
        int sum = 0;
        int maxSum;
        int startIndex = 0;
        int k = new Scanner(System.in).nextInt();
        for (int i = 0; i < k; i++)
            sum += arr[i];

        maxSum = sum;

        //Start Sliding window by subtracting the first number in the previous window
        // and adding the new number in the next window
        int endIndex = k;
        while (endIndex < arr.length) {
            sum -= arr[startIndex];
            startIndex++;

            sum += arr[endIndex];
            endIndex++;

            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("Max Average of Sub Array: "+(maxSum/k));
    }
}
