package ArrayProblems;

import java.util.Arrays;

/**
 1. Idea here is to sort the arrays and as arr[i] < dep[j]
    implies train has not left and count gets incremented
 */
public class MinPlatformsForTrain {

    public static void main(String[] args) {

        double[] arr = {9.00, 9.45, 9.55, 10.30, 11.00, 15.00, 18.00};
        double[] dep = {9.30, 12.00, 11.30, 11.30, 11.50, 19.00, 20.00};
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
        if (arr.length == 0 || dep.length == 0 || arr.length != dep.length) {
            return 0; // No trains or mismatched arrays
        }
        if (arr.length == 1) {
            return 1; // Only one train, one platform needed
        }
        
        /**
         * Sort the arrival and departure arrays.
         * Sorting is essential to ensure that we can efficiently determine the number of platforms needed
         * at any given time by comparing the arrival and departure times in chronological order.
         * This allows us to process the trains in the order they arrive and depart,
         * which is crucial for accurately counting the platforms required.
         * The sorting operation has a time complexity of O(n log n), where n is the number of trains.
         * After sorting, we can efficiently traverse both arrays to determine the maximum number of platforms needed at any time.
         * The two-pointer technique used in the subsequent logic ensures that we only traverse each array once,
         * leading to a linear time complexity of O(n) for the counting process.
         * Thus, the overall time complexity of this algorithm is O(n log n) due to the sorting step,
         * followed by O(n) for the counting step, resulting in an efficient solution for the problem.
         */
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0;
        int platformCount = 1;
        int maxPlatforms = 1;

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
                platformCount++;
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
                platformCount--;
                j++;
            }
            /**
             * This line updates the maximum count of platforms needed at any point in time.
             * It compares the current count of platforms needed with the maximum count recorded so far.
             * If the current count is greater than the maximum count, it updates the maximum count.
             * This is essential for determining the peak number of platforms required during the schedule.
             */
            maxPlatforms = Math.max(maxPlatforms, platformCount);
        }
        return maxPlatforms;
    }
}
