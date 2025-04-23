package Sorting;

import java.util.Arrays;

import static Sorting.Swap.swap;

public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = {4,1,5,2,3,0,6,8,7};
        int swap = 0;
        for(int i=0; i<arr.length; i++){
            //Iterate j -> 0 to n-i-1 as the maximum element would be at the last place in the previous iteration
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                    swap = 1;
                }
            }
            //if swap -> 0 => Array is already sorted and time complexity is O(n)
            if(swap==0){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
