package ArrayProblems;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    /**
     * Given an array nums and a sliding window size k, find the maximum value in each sliding window.
     * For example, given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     * The sliding windows are:
     * [1 3 -1] -3 5 3 6 7
     * 1 [3 -1 -3] 5 3 6 7
     * 1 3 [-1 -3 5] 3 6 7
     * 1 3 -1 [-3 5 3] 6 7      
     * 1 3 -1 -3 [5 3 6] 7
     * 1 3 -1 -3 5 [3 6 7]
     * Therefore, the output is [3,3,5,5,6,7].
     * 
     * The algorithm works as below:
     * 1. Use a deque to store indices of array elements. The deque will store indices in decreasing order of their corresponding values.
     * 2. For each element in the array, remove indices from the front of the deque if they are out of the bounds of the current window.
     * 3. Remove indices from the back of the deque while the current element is greater than the elements corresponding to those indices.
     * 4. Add the current index to the back of the deque.
     * 5. The front of the deque contains the index of the maximum element for the current window.
     * 6. Repeat the process until all windows are processed.
     * 7. The time complexity of this algorithm is O(n) since each element is added and removed from the deque at most once.
     * 8. The space complexity is O(k) for storing indices in the deque.
     * 
     * @param nums number array
     * @param k window size
     * @return maximum values for each sliding window
     */
    private static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Remove indices that are not in the bounds of the current window
            // At any given point, the deque contains i-2, i-1, i for window size 3
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove indices whose corresponding values are less than nums[i] as they are not useful
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // Add current index to the deque
            deque.offerLast(i);
            // The front of the deque is the max of the window if we have processed at least k elements
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
