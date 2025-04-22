package ArrayProblems;

import java.util.Arrays;

public class CyclicRotationOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 3;

        // Optimizing the rotation
        k = k % arr.length; // Handle cases where k > n
        reverse(arr, 0, arr.length - k - 1);
        reverse(arr, arr.length - k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    // Helper method to reverse a portion of the array
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