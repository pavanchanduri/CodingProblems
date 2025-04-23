package Sorting;

import java.util.Arrays;

import static Sorting.Swap.swap;

/**
 * 1. Pick a pivot element (preferably the last element)
 * 2. Loop such that all elements less than the pivot move before pivot and
 *    elements larger than pivot move after pivot
 * 3. Swap the pivot element with the position where the greater element than pivot starts
 * 4. Recursively call quickSort function on left and right
 *    i.e., quickSort(arr,left, pivotIndex-1) & quickSort(arr, pivotIndex+1, end)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,2,6,4,1,3};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int index = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                index++;
                swap(arr, index, i);
            }
        }
        index++;
        swap(arr, index, right);
        return index;
    }
}
