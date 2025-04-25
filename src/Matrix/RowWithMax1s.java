package Matrix;

public class RowWithMax1s {

    public static void main(String[] args) {
        int[][] arr = {{0,0,0}, {0,0,1},{0,0,1}};
        System.out.println(rowWithMax1s(arr));
    }

    public static int rowWithMax1s(int[][] arr) {
        // code here
        int count = 0, maxCount = 0, index = -1;;
        for(int i=0;i<arr.length;i++) {
            int upperBound = upperBound(arr[i], 0, arr[i].length) ;
            if(upperBound == arr[i].length) {
                count = 0;
            } else {
                count = arr[i].length-upperBound;
            }
            if(count>maxCount) {
                maxCount = count;
                index = i;
            }
        }
        return index;
    }

    static int upperBound(int[] arr, int x, int n) {
        int low = 0, high = n - 1;
        int ans = n;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] > x) {
                ans = mid;
                // look for a smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
