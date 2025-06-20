package ArrayProblems;

import java.util.Arrays;

public class CyclicRotationOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3; // Number of positions to rotate
        rotateArray(arr, k);
    }

    /**
     * This method rotates the array to the right by k positions using the reverse method.
     * 
     * The algorithm works as follows:
     * 1. Normalize k to ensure it is within the bounds of the array length.
     * 2. Reverse the first n-k elements of the array.
     * 3. Reverse the last k elements of the array.
     * 4. Reverse the entire array to achieve the final rotated order.
     *
     * @param arr The array to be rotated
     * @param k The number of positions to rotate
     */
    private static void rotateArray(int[] arr, int k) {
        int n = arr.length;
        // Normalize k to ensure it is within the bounds of the array length
        k = k % n;

        // Reverse the first n-k elements
        reverse(arr, 0, n-k-1);
        // Reverse the last k elements
        reverse(arr, n-k, n-1);
        // Reverse the entire array
        reverse(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));
    }

    /**
     * This method reverses a portion of the array from start to end indices.
     * 
     * The algorithm works as follows:
     * 1. Use a while loop to swap elements at the start and end indices.
     * 2. Increment the start index and decrement the end index until they meet.
     *
     * @param arr The array to be reversed
     * @param start The starting index for reversal
     * @param end The ending index for reversal
     */
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}