package Sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 4,1,5,2,3,0,6,8,7 };
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int prev = i-1;
            while (prev >= 0 && arr[prev] > current) {
                arr[prev+1] = arr[prev]; //Create a position for the current element
                prev--;
            }
            arr[prev+1] = current; //Put the current element in its correct place
        }
        System.out.println(Arrays.toString(arr));
    }
}
