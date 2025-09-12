package Matrix;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestIn2DMatrix {

    public static void main(String[] args) {
        int[][] mat =     {{16, 28, 60, 64},
                           {22, 41, 63, 91},
                           {27, 50, 87, 93},
                           {36, 78, 87, 94 }};
        int k = 3;
        System.out.println(kthSmallest(mat,mat.length,k));
    }

    /**
     * This method finds the k-th smallest element in a 2D matrix.
     * Idea is the kth smallest element is the root of a max-heap of size k
     * The algorithm works as follows:
     * 1. Create a max-heap to store the k smallest elements.
     * 2. Iterate through all elements in the matrix.
     * 3. Add each element to the heap.
     * 4. If the heap size exceeds k, remove the largest element.
     * 5. The root of the heap will be the k-th smallest element.
     * 
     * @param mat the input 2D matrix
     * @param n the number of rows in the matrix
     * @param k the k-th position to find
     * @return the k-th smallest element in the matrix
     */
    public static int kthSmallest(int[][] mat, int n, int k) {

        // Max-heap to store the k smallest elements through a custom comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Iterate through all elements
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                maxHeap.add(mat[i][j]); // Add the current element to the heap
                // If the heap size exceeds k, remove the smallest element
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        // The root of the heap is the k-th smallest element
        return maxHeap.peek();
    }
}
