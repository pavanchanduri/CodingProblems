package Sorting;

import java.util.Arrays;

import static Sorting.Swap.swap;

/**
 * 1. Pick the minimum element in each iteration.
 * 2. Swap the minimum element with the first place and so on
 * 3. After each iteration, the found minimum element takes its correct place
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {4,1,5,2,3,0,6,8,7};

        for(int i = 0; i<arr.length-1; i++){
            int minIndex = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }
}
