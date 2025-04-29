package ArrayProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 Run a loop until k-1 and make the previous minElement the max element i.e., MAX_VALUE
 This way the next element would be the minimum element which would be returned
 */
public class FindKSmallestElement {

    public static void main(String[] args) {

        int[] arr = {10,-2,-5, 1,5,7,9,-6,13};
        int k = 1;

        // Find the k-th largest element
        int kthSmallest = findKthSmallest(arr, k);
        System.out.println(kthSmallest);
    }

    private static int findKthSmallest(int[] arr, int k) {
        // Min-heap to store the k smallest elements through a custom comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new CustomComparator());

        // Iterate through all elements
        for (int num : arr) {
            minHeap.add(num); // Add the current element to the heap

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }

    static class CustomComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer number1, Integer number2) {

            if(number1 < number2) {
                return 1; //Swap
            } else if(number1 > number2) {
                return -1; //Do nothing
            }
            return 0;
        }
    }
}
