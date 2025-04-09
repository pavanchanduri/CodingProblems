package Arrays;

/**
 Run a loop until k-1 and make the previous minElement the max element i.e., MAX_VALUE
 This way the next element would be the minimum element which would be returned
 */
public class FindKSmallestElement {

    public static void main(String[] args) {

        int[] arr = {10,-2,-5, 1,5,7,9,-6,13};
        int k = 2;
        int minElement = Integer.MAX_VALUE;

        for(int i=0;i< k;i++) {
            minElement = findSmallest(arr);
        }

        System.out.println(minElement);
    }

    private static int findSmallest(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i=0;i< arr.length;i++) {
            if(arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        arr[minIndex] = Integer.MAX_VALUE;
        return min;
    }
}
