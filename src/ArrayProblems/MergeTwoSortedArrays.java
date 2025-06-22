package ArrayProblems;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9,13,14,15};
        int[] arr2 = {2,4,6,8,10,12,14,15,16,17};

        int[] mergedArray = mergeSortedArrays(arr1, arr2);
        System.out.println("Merged Array:");
        // Print the merged array
        if (mergedArray.length == 0) {
            System.out.println("No elements to display");
            return;
        }

        for(int num:mergedArray)
        {
            System.out.print(num+" ");
        }
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     * 
     * The algorithms works as follows:
     * 1. Initialize three pointers: i for arr1, j for arr2,
     *    and k for the merged array.
     * 2. Compare elements from both arrays and add the smaller one to the merged array
     *    while incrementing the respective pointer.
     * 3. If elements are equal, add both to the merged array and increment both
     *    pointers.
     * 4. Once one of the arrays is fully traversed, copy the remaining elements
     *    from the other array to the merged array.
     * 5. Return the merged sorted array.
     * 
     * @param arr1 First sorted array
     * @param arr2 Second sorted array
     * @return Merged sorted array containing elements from both input arrays
     */
    private static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }

        int[] mergedArray = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) { // If arr1[i] is smaller, add it to the merged array
                mergedArray[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) { // If arr2[j] is smaller, add it to the merged array
                mergedArray[k++] = arr2[j++];
            } else { // If both elements are equal, add both to the merged array
                mergedArray[k++] = arr1[i++];
                mergedArray[k++] = arr2[j++];
            }
        }

        //Copy rest of the elements from arr1
        while(i<arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        //Copy rest of the elements from arr2
        while(j<arr2.length) {
            mergedArray[k++] = arr2[j++];
        }
        return mergedArray;
    }
}
