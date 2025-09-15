package ArrayProblems;

public class SmallestSubArrayWithSumGreaterThanK {
    public static void main(String[] args) {
        int[] arr = {1,10,3,40,18};
        int k = 50;
        System.out.println(smallestSubArrayLength(arr, arr.length, k));
    }

    /**
     * This method finds the length of the smallest sub-array with a sum greater than k.
     * The algorithm uses a sliding window approach to find the minimum length sub-array.
     * The algorithm works as follows:
     * 1. Initialize two pointers (start and end) to represent the current window.
     * 2. Expand the window by moving the end pointer and adding elements to the current sum until it exceeds k.
     * 3. Once the current sum exceeds k, contract the window by moving the start pointer and subtracting elements from the current sum.
     * 4. Update the minimum length whenever a valid sub-array is found.
     * 5. Continue this process until the end pointer reaches the end of the array.
     * If no such sub-array is found, return 0.
     * 
     * @param arr the input array
     * @return the length of the smallest sub-array with sum greater than k
     */
    private static int smallestSubArrayLength(int[] arr, int n, int k) {
        int start = 0, end = 0;
        int currentSum = 0;
        int minLength = arr.length+1;;
        boolean found = false;

        while(end < n) {

            //keep adding until current sum is less than k 
            //or until end reaches the end of the array
            while(currentSum <= k && end < n) {
                currentSum += arr[end++];
            }

            //when current sum is greater than k, try to shrink the window
            while(currentSum > k && start < n) {
                found = true;
                minLength = Math.min(minLength, end - start);
                /**shrink the window from the start
                and check if the sum is still greater than k
                if it is, update the minLength
                else, break the loop and move the end pointer
                to find a new window**/
                currentSum -= arr[start++];
            }
        }
        if(found) {
            return minLength;
        }
        return 0;
    }
}
