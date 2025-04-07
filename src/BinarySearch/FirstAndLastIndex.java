package BinarySearch;

/**
1. In the first iteration, mark the first index as you find the target element and check in the left side
   making right index = mid-1 and accordingly change the first index as you find it in the left window
2. In the next loop, repeat the same as Step 1 but in the right window by making left index = mid+1 after finding
   the target element which will be marked as the last index
 **/
public class FirstAndLastIndex {

    public static void main(String[] args) {

        int[] arr = {1,2,3,3,5,5,5,5,5,5,5,5,5,8,8,9};
        int left = 0, right = arr.length-1;
        int first = -1, last = -1;
        int target = 5;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        left = 0;
        right = arr.length-1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(first+" "+last);
    }
}
