package Matrix;

public class MedianInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(median(matrix, 3, 3));
    }

    /**
     * Find median in a row-wise sorted matrix
     * The algorithm uses binary search on the value range to find the median.
     * It first determines the minimum and maximum values in the matrix.
     * Then, it performs a binary search on this range, counting how many elements are less
     * than or equal to the mid-value in each iteration.
     * Depending on the count, it adjusts the search range until it finds the median.
     *
     * @param matrix the input row-wise sorted matrix
     * @param r      the number of rows in the matrix
     * @param c      the number of columns in the matrix
     * @return the median value
     */
    private static int median(int[][] matrix, int r, int c) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < r; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][c - 1]);
        }

        int desired = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;

            for (int i = 0; i < r; ++i)
                place += countSmallerThanMid(matrix[i], mid);

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    /**
     * Counts the number of elements in the given array that are less than or equal to the specified value.
     *
     * @param arr the input array
     * @param mid the value to compare against
     * @return the count of elements less than or equal to the specified value
     */
    private static int countSmallerThanMid(int[] arr, int mid) {
        int l = 0, h = arr.length - 1;
        while (l <= h) {
            int md = l + (h - l) / 2;
            if (arr[md] <= mid)
                l = md + 1;
            else
                h = md - 1;
        }
        return l;
    }
}
