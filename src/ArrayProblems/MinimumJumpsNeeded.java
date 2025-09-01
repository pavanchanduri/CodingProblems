package ArrayProblems;

/**
 1. Iterate through the array and find a maxIndex and for each jump find an endIndex
 2. Until 'i' reached endIndex, compute the maxIndex, which would correspond to the next jump
 */
public class MinimumJumpsNeeded {

    public static void main(String[] args) {
        int[] arr = {1,3,5,9,4,2,6,3};
        int result = minJumps(arr);
        System.out.println("Minimum jumps needed: " + result);
    }

    /**
     * This method calculates the minimum number of jumps needed to reach the end of the array.
     * Each element in the array represents the maximum jump length from that position.
     * 
     * The algorithm works as follows:
     * 1. Initialize `maxIndex` to track the farthest reachable index.
     * 2. Use `endIndex` to track the end of the current jump range
     * 3. Iterate through the array, updating `maxIndex` as the maximum of the current `maxIndex` and the index plus the jump length at that index.
     * 4. When the current index reaches `endIndex`, increment the jump count and update `endIndex` to `maxIndex`.
     * 5. If at any point `endIndex` reaches or exceeds the last index of the array, return the jump count.
     * If the end of the array is not reachable, return -1.
     *
     * @param arr The input array where each element indicates the maximum jump length.
     * @return The minimum number of jumps needed to reach the end of the array.
     */
    private static int minJumps(int[] arr) {
        int maxIndex = 0, endIndex = 0;
        int jumps = 0;

        for(int i = 0; i < arr.length; i++){
            /*
             * If the current index is greater than the maximum reachable index,
             * it means we cannot proceed further, hence return -1.
             * This condition is not explicitly checked here,
             * but if `maxIndex` is less than `i`, it implies that we are
             * stuck and cannot make any further jumps. 
             * If we reach this point, it means we can still make jumps.
             * 
             */
            maxIndex = Math.max(maxIndex, i + arr[i]);

            /**
             * If we reach the end of the current jump range (endIndex),
             * we need to make a jump.
             * We update the endIndex to the maximum reachable index found so far.
             * If the endIndex is equal to the current index, it means we are at the
             * end of the current jump range and need to make a jump.   
             * If the endIndex is updated to maxIndex,
             * it means we can reach further in the next jump.
             * We increment the jump count.
             * This ensures that we only count a jump when we actually need to make one,
             * i.e., when we reach the end of the current jump range.
             */
            if(endIndex == i) {
                endIndex = maxIndex;
                jumps++;
            }

            /**
             * If the endIndex reaches or exceeds the last index of the array,
             * it means we can reach the end of the array with the current number of jumps.
             * We return the number of jumps made so far.
             */
            if(endIndex >= arr.length - 1){
                return jumps;
            }
        }
        return -1; // No jumps possible
    }
}
