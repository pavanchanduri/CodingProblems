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

        // The root of the heap is the k-th largest element
        return minHeap.peek();
    }
}
