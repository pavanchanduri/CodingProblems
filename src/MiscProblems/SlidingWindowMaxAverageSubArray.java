package MiscProblems;

import java.util.Scanner;

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
