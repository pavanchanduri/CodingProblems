package ArrayProblems;

import java.util.Scanner;
import java.util.Arrays;

/**
 1. Find minimum among arr[0]+k and arr[i]-k
 2. Find maximum among arr[n-1]-k and arr[i-1]+k
 3. Find the minimum result among existing result and max-min
 */
public class MinimizeHeights {

    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 16, 20};
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.close();
        minimizeHeights(arr, k);
    }

    /**
     * This method minimizes the height difference in an array after adjusting each element by a given value k.
     * It sorts the array and calculates the minimum possible height difference after adjustments.
     *
     * The algorithm works as follows:
     * 1. Sort the array.
     * 2. Initialize the result as the difference between the maximum and minimum heights.
     * 3. Iterate through the array, adjusting each height by k.
     * 4. For each height, calculate the minimum and maximum heights after adjustment.
     * 5. Update the result with the minimum difference found.
     * 
     * @param arr The array of heights.
     * @param k The adjustment value.
     */
    private static void minimizeHeights(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int result = arr[n - 1] - arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue; // Skip if the height becomes negative
            int minHeight = Math.min(arr[0] + k, arr[i] - k);
            int maxHeight = Math.max(arr[n - 1] - k, arr[i - 1] + k);
            result = Math.min(result, maxHeight - minHeight);
        }
        System.out.println("Minimum difference is: " + result);
    }
}
