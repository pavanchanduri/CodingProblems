package BinarySearch;

public class FirstAndLastIndex {

    public static void main(String[] args) {

        int[] arr = {1,2,3,3,5,5,5,5,5,8};
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
