package ArrayProblems;


/**
 1. Take index i @ arr1.length-arr2.length-1 and index j @ arr2.length-1
 2. Take another index @ arr1.length-1
 3. Keep iterating until i<0 && j<0 and if the element in arr1 is more than arr2, copy arr1 @ i to arr1 @ index
 4. If the element in arr2 is more than arr1, copy arr2 @ j to arr1 @ index
 5. Decrement the pointers at each and every step
 6. Incases where elements are still left in arr2, copy them at arr1 @ index and decrement index and j
 */
public class MergeSortedArraysWithoutExtraSpace {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9,13,14,15,0,0,0,0,0,0,0,0,0,0}; //Extra space to accommodate arr2
        int[] arr2 = {2,4,6,8,10,12,14,15,16,17};

        int index = arr1.length-1;
        int i=arr1.length-arr2.length-1, j=arr2.length-1;

        while(i>=0&&j>=0) {
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
