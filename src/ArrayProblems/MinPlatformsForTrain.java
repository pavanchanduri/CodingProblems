package ArrayProblems;

import java.util.Arrays;

/**
 1. Idea here is to sort the arrays and as arr[i] < dep[j]
    implies train has not left and count gets incremented
 */
public class MinPlatformsForTrain {

    public static void main(String[] args) {

        double[] arr = {9, 9.75, 9.9, 11, 15, 18};
        double[] dep = {9.3, 12, 11.5, 11.9, 19, 20};
        int result = minPlatforms(arr, dep);
        System.out.println("Minimum platforms needed: " + result);
    }

    /**
     * This method calculates the minimum number of platforms required for the trains.
     * 
     * The algorithm works as follows:
     * 1. Sort the arrival and departure arrays.
     * 2. Use two pointers, one for the arrival array and one for the departure array.
     * 3. Iterate through the arrival array:
     *   - If the current arrival time is less than or equal to the current departure time
     *     increment the count of platforms needed.
     *  - If the current arrival time is greater than the current departure time
     *    decrement the count of platforms needed.
     *  - Keep track of the maximum number of platforms needed at any time.
     * 4. Return the maximum count as the result.
     *
     * @param arr The array of arrival times.
     * @param dep The array of departure times.
     * @return The minimum number of platforms needed.
     */
    private static int minPlatforms(double[] arr, double[] dep) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int count = 0;
        int maxCount = 0;

        while(i<arr.length) {
            if(arr[i]<=dep[j]) {
                /**
                 * This condition checks if the current train's arrival time is less than or equal to
                 * the current train's departure time.
                 * If true, it means that the current train has not yet left, and a new train has arrived,
                 * so we increment the count of platforms needed.
                 * The count variable keeps track of the number of platforms currently in use.
                 * The maxCount variable keeps track of the maximum number of platforms needed at any time.
                 * The i variable is incremented to move to the next train's arrival time.
                 * The j variable remains unchanged because we are still considering the same train's departure time.
                 * This is crucial for determining the maximum number of platforms needed at any point in time.
                 */
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            } else if(arr[i]>dep[j]) {
                /**
                 * This condition checks if the current train's arrival time is greater than the current train's
                 * departure time.
                 * If true, it means that the current train has left, and we can decrement the count of platforms needed.
                 * The count variable is decremented to reflect that one platform is now free.
                 * The j variable is incremented to move to the next train's departure time.
                 * This ensures that we are always comparing the current arrival time with the correct departure time.
                 */
                count--;
                j++;
            }
        }
        return maxCount;
    }
}
