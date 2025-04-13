package ArrayProblems;

import java.util.*;

public class MergingIntervals {

    public static void main(String[] args) {

        int[][] intervals ={{1,3},{2,6},{8,10},{15,16}};

//        if(intervals.length<=1) {
//            return intervals;
//        }

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
        result.toArray(new int[result.size()][]);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }
}