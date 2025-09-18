package Matrix;

public class RowWithMax1s {

    public static void main(String[] args) {
        int[][] arr = {{0,0,0}, {0,0,1},{0,0,1}};
        System.out.println(rowWithMax1s(arr));
    }

    /**
     * Function to find the row with the maximum number of 1s.
     * Each row of the matrix is sorted.
     * The algorithm works as follows:
     * 1. For each row, it uses a binary search (upperBound function) to find the first occurrence of 1.
     * 2. It calculates the number of 1s in that row by subtracting the index of the first 1 from the total number of columns.
     * 3. It keeps track of the maximum count of 1s found and the corresponding row index.
     * 4. Finally, it returns the index of the row with the maximum number of 1s.
     * If no 1s are found in any row, it returns -1.
     * 
     * @param arr 2D array (matrix) where each row is sorted
     * @return index of the row with the maximum number of 1s, or -1 if no 1s are found
     */
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

    /**
     * Finds the index of the first element in a sorted array that is greater than a given value x.
     * This function implements a binary search algorithm to efficiently locate the upper bound.
     * If all elements in the array are less than or equal to x, the function returns the length of the array.
     * 
     * @param arr
     * @param x
     * @param n
     * @return
     */
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
