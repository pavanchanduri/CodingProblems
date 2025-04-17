package ArrayProblems;

/**
 Run a loop until k-1 and make the previous minElement the max element i.e., MAX_VALUE
 This way the next element would be the minimum element which would be returned
 */
public class FindKLargestElement {

    public static void main(String[] args) {

        int[] arr = {10,-2,-5, 1,5,7,9,-6,13};
        int k = 4;
        int maxElement = Integer.MIN_VALUE;

        for(int i=0;i< k;i++) {
            maxElement = findLargest(arr);
        }

        System.out.println(maxElement);
    }

    private static int findLargest(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i=0;i< arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        arr[maxIndex] = Integer.MIN_VALUE;
        return max;
    }
}
