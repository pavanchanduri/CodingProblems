package ArrayProblems;

/**
 1. Iterate through the array and find a maxIndex and for each jump find an endIndex
 2. Until 'i' reached endIndex, compute the maxIndex, which would correspond to the next jump
 */
public class MinimumJumpsNeeded {

    public static void main(String[] args) {
        int[] arr = {1,3,5,8,4,2,6,3};
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
            maxIndex = Math.max(maxIndex, i + arr[i]);

            if(endIndex == i) {
                endIndex = maxIndex;
                jumps++;
            }

            if(endIndex >= arr.length - 1){
                return jumps;
            }
        }
        return -1; // No jumps possible
    }
}
