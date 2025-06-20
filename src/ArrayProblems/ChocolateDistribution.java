package ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem - <a href="https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1">...</a>
 * Idea is to sort the array and then find the maximum minimum element difference in m sized window
 */
public class ChocolateDistribution {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(3, 4, 1, 9, 56, 7, 9, 12));
        int m = 5;
        System.out.println(findMinDiff(list, m));
    }

    /**
     * The Algorithm works as follows:
     * 1. Sort the array of chocolates.
     * 2. Use a sliding window of size m to find the minimum difference between the
     *    maximum and minimum chocolates in that window.
     * 3. Iterate through the sorted array, calculating the difference between the
     *    maximum and minimum chocolates in each window of size m.
     * 4. Keep track of the minimum difference found.
     * 5. Return the minimum difference as the result.
     * 
     * @param arr - ArrayList of integers representing chocolates
     * @param m - Number of students
     * @return Minimum difference between the maximum and minimum chocolates distributed to students
     */
    public static int findMinDiff(ArrayList<Integer> arr, int m) {

        Collections.sort(arr);
        int i=0;
        int minDiff = Integer.MAX_VALUE;
        while(m<=arr.size() && i<arr.size()) {
            int diff = arr.get(m-1)-arr.get(i);
            m++;
            i++;
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
}
