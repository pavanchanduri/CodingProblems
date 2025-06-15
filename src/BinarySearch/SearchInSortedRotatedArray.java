package BinarySearch;

import java.util.Scanner;

/**
1. Find the minimum element in the rotated array by applying binary search iteratively
2. Once the minimum element is found, apply binary search in two windows i.e., 0 -> minIndex-1 and minIndex -> arr.length-1
   as the element would be in either of the windows as the elements are sorted and therefore the array can be divided in to
   2 parts using the minIndex
 */
public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,9,10,11,12,13,1,2,3,4};
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        scanner.close();
        int minIndex = findMin(arr);

        int result = binarySearch(arr, minIndex, arr.length-1, target);

        if(result == -1) {
            result = binarySearch(arr, 0, minIndex-1, target);
        }
        System.out.println(result);
    }

    public static int binarySearch(int[] arr, int left, int right, int target) {

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int findMin(int[] arr) {

        int left = 0, right = arr.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] < arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
