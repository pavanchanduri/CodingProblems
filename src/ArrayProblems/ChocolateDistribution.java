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
