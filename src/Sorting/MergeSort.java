package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,2,6,4,1,3};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {
            int mid = left +(right-left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();
        int i=start, j=mid+1;
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            } else {
                temp.add(arr[j]);
                j++;
            }
        }

        /* Add the remaining elements */
        while(i<=mid){
            temp.add(arr[i]);
            i++;
        }
        while(j<=end){
            temp.add(arr[j]);
            j++;
        }

        for(int k=0;k<temp.size();k++){
            arr[start+k] = temp.get(k);
        }
    }
}
