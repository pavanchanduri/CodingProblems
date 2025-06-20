package ArrayProblems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 Run a loop until k-1 and make the previous minElement the max element i.e., MAX_VALUE
 This way the next element would be the minimum element which would be returned
 */
public class FindKSmallestElement {

    public static void main(String[] args) {

        int[] arr = {10,-2,-5, 1,5,7,9,-6,13};
        int k = 4;

        // Find the k-th largest element
        int kthSmallest = findKthSmallest(arr, k);
        System.out.println(kthSmallest);
    }

    /**
     * This method finds the k-th smallest element in an array using a max-heap.
     * It maintains a heap of size k, ensuring that only the k smallest elements are kept.
     * 
     * The algorithm works as follows:
     * 1. Initialize a max-heap to store the k smallest elements.
     * 2. Iterate through each element in the array:
     *    - Add the current element to the heap.
     *    - If the size of the heap exceeds k, remove the largest element (the root of the max-heap).
     * 3. After processing all elements, the root of the heap will be the k-th smallest element in the array.
     *
     * @param arr The input array from which to find the k-th smallest element
     * @param k The position of the smallest element to find (1-based index)
     * @return The k-th smallest element in the array
     */
    private static int findKthSmallest(int[] arr, int k) {
        // Max-heap to store the k smallest elements through a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through all elements
        for (int num : arr) {
            maxHeap.add(num); // Add the current element to the heap

            // If the heap size exceeds k, remove the max element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The root of the heap is the k-th smallest element
        return maxHeap.peek();
    }
}
