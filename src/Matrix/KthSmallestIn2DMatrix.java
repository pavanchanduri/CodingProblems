package Matrix;

import java.util.Comparator;
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

    public static int kthSmallest(int[][] mat, int n, int k) {

        // Min-heap to store the k smallest elements through a custom comparator
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new CustomComparator());

        // Iterate through all elements
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                minHeap.add(mat[i][j]); // Add the current element to the heap

                // If the heap size exceeds k, remove the smallest element
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
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
