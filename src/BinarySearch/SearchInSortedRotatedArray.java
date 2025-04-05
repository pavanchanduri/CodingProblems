package BinarySearch;

import java.util.Scanner;

public class SearchInSortedRotatedArray {

    public static void main(String[] args) {
        int[] arr = {5,1,3};
        int target = new Scanner(System.in).nextInt();
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
