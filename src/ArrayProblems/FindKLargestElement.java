package ArrayProblems;

import java.util.PriorityQueue;

public class FindKLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, -2, -5, 1, 5, 7, 9, -6, 13};
        int k = 4;

        // Find the k-th largest element
        int kthLargest = findKthLargest(arr, k);
        System.out.println(kthLargest);
    }

    /**
     * This method finds the k-th largest element in an array.
     * Idea is the kth max element is the root of a min-heap of size k.
     * 
     * The algorithm works as follows:
     * 1. Create a min-heap to store the k largest elements.
     * 2. Iterate through all elements in the array.
     * 3. Add each element to the heap.
     * 4. If the heap size exceeds k, remove the smallest element.
     * 5. The root of the heap will be the k-th largest element.
     *
     * @param arr The input array
     * @param k The k-th position to find
     * @return The k-th largest element
     */
    private static int findKthLargest(int[] arr, int k) {
        // Min-heap to store the k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through all elements
        for (int num : arr) {
            minHeap.add(num); // Add the current element to the heap

            // If the heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        System.out.println(minHeap);

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}
