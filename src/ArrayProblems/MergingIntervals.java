package ArrayProblems;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergingIntervals {

    public static void main(String[] args) {

        int[][] intervals ={{1,3},{2,6},{8,10},{15,16}};

        int[][] mergedIntervals = mergeIntervals(intervals);

        for(int[] interval: mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }

    /**
     * Merges overlapping intervals in a given array of intervals.
     *
     * The algorithm works as follows:
     * 1. Sort the intervals based on the starting point.
     * 2. Initialize a list to hold the merged intervals.
     * 3. Iterate through the sorted intervals:
     *    - If the current interval overlaps with the last merged interval, merge them by updating
     *      the end of the last merged interval to the maximum end of both intervals.
     *    - If it does not overlap, add the current interval as a new merged interval.
     * 4. Convert the list of merged intervals back to a 2D array and return it.
     * 
     * @param intervals An array of intervals represented as pairs of integers.
     * @return A 2D array containing the merged intervals.
     */
    private static int[][] mergeIntervals(int[][] intervals) {

        //Sort in ascending order by the first element
        Arrays.sort(intervals, Comparator.comparing(i->i[0]));

        List<int[]> result = new ArrayList<>();

        //Add the first interval to the result list
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for(int[] interval: intervals) {
            if(interval[0]<=newInterval[1]) {
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        //Convert the list to an array
        return result.toArray(new int[result.size()][]);
    }
}