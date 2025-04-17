package ArrayProblems;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SubArrayMaximum {

    public static void main(String[] args) {
        List<Integer> result = findSubarrayMaximum(new int[]{1,3,-1,-3,5,3,7,1,6}, 3);
        for(Integer i : result) {
            System.out.print(i+" ");
        }
    }

    public static List<Integer> findSubarrayMaximum(int @NotNull [] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            //remove elements that are not part of the current sliding window
            //i.e., indexes less than or equal to i-k
            if (!queue.isEmpty() && (queue.getFirst() <= (i - k))) {
                queue.removeFirst();
            }
            //Remove all element indices from the dequeue which are less than the current element in the array
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
            }
            //add the array element index to the dequeue at the last
            queue.addLast(i);

            //The element at the front of the dequeue is the element that is to be added to the list
            if (i >= k-1) {
                result.add(nums[queue.getFirst()]);
            }
        }
        return result;
    }
}
