package ArrayProblems;

import java.util.ArrayList;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        int inversionCount = mergeSort(arr,0,arr.length-1);

        System.out.println(inversionCount);
    }

    /**
     * This method sorts the array and counts inversions using the merge sort algorithm.
     * 
     * The algorithm works as follows:
     * 1. If the start index is less than the end index, it means there
     *   are at least two elements to sort.
     * 2. Calculate the middle index.
     * 3. Recursively call mergeSort on the left half (from start to mid
     *   index) and the right half (from mid + 1 to end index).
     * 4. Merge the two halves while counting inversions.
     * 5. The merge function combines the two halves and counts how many
     *    inversions are found.
     *
     * @param arr The array to be sorted
     * @param start The starting index
     * @param end The ending index
     * @return The number of inversions found
     */
    private static int mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            int leftInversionCount = mergeSort(arr, start, mid);
            int rightInversionCount = mergeSort(arr, mid + 1, end);
            int inversionCount = merge(arr, start, mid, end);

            return inversionCount + leftInversionCount + rightInversionCount;
        }
        return 0;
    }

    /**
     * This method merges two halves of the array and counts inversions.
     * 
     * The algorithm works as follows:
     * 1. Create a temporary list to hold the merged elements.
     * 2. Use two pointers, one for each half of the array.
     * 3. Compare the elements at the pointers:
     *    - If the element in the left half is less than or equal to the
     *      element in the right half, add the left element to the temporary list.
     *    - If the element in the right half is smaller, add it to the temporary list
     *      and count inversions.
     * 4. After processing both halves, add any remaining elements from either half to the temporary list.
     * 5. Copy the merged elements back to the original array.
     * 6. Return the count of inversions found during the merge.
     * 
     * @param arr The array to be merged
     * @param start The starting index of the left half
     * @param mid The ending index of the left half (midpoint)
     * @param end The ending index of the right half
     * @return The number of inversions found during the merge
     */
    private static int merge(int[] arr, int start, int mid, int end) {

        ArrayList<Integer> temp = new ArrayList<>();
        int inversionCount = 0;
        int i = start, j = mid + 1;
        while(i<=mid && j<=end) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else if(arr[i] > arr[j]) {
                temp.add(arr[j]);
                j++;
                inversionCount+=mid-i+1; //When arr[i]>arr[j], all elements from i till mid are also more than arr[j]
            }
        }
        while(i<=mid) {
            temp.add(arr[i]);
            i++;
        }
        while(j<=end) {
            temp.add(arr[j]);
            j++;
        }

        for(int idx=start;idx<=end;idx++) {
            arr[idx] = temp.get(idx-start);
        }
        return inversionCount;
    }
}
