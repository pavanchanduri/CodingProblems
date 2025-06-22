package ArrayProblems;


/**
 * Merge two sorted arrays without using extra space.
 * The first array has enough space at the end to accommodate the second array.
 * This implementation assumes that the first array is larger than or equal to the second array.
 * 
 * The algorithm works as follows:
 * 1. Start from the end of both arrays.
 * 2. Compare the elements from the end of both arrays. 
 * 3. Place the larger element at the end of the first array.
 * 4. Move the index of the array from which the element was taken.
 * 5. Repeat until all elements from the second array are placed in the first array.
 * 6. If there are any remaining elements in the second array, copy them to the first array.
 */
public class MergeSortedArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9,13,14,15,0,0,0,0,0,0,0,0,0,0}; //Extra space to accommodate arr2
        int[] arr2 = {2,4,6,8,10,12,14,15,16,17};

        int index = arr1.length-1;
        int i=arr1.length-arr2.length-1, j=arr2.length-1;

        while(i>=0&&j>=0) { 
            // Compare elements from the end of both arrays
            // Place the larger element at the end of arr1
            // and move the index of the array from which the element was taken
            // If arr1[i] is greater than or equal to arr2[j], place arr1[i] at index and decrement i
            // Otherwise, place arr2[j] at index
            // and decrement j
            // Decrement index after placing the element
            // This ensures that we are filling arr1 from the end towards the beginning
            // This is done to avoid overwriting elements in arr1 that have not been compared yet
            // This is a two-pointer approach where we are comparing elements from both arrays
            // and placing the larger element at the end of arr1
            // This ensures that we are merging the two arrays in sorted order
            // without using extra space
            if(arr1[i]>=arr2[j]) {
                arr1[index--] = arr1[i--];
            } else {
                arr1[index--] = arr2[j--];
            }
        }

        while(j>=0) {
            arr1[index--] = arr2[j--];
        }

        for(int num: arr1) {
            System.out.print(num+" ");
        }
    }
}
