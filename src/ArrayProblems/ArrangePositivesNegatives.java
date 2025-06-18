package ArrayProblems;

public class ArrangePositivesNegatives {

    /**
     * This program arranges the elements of an array such that all negative numbers
     * are on the left side and all positive numbers are on the right side.
     * It uses a two-pointer approach to achieve this in O(n) time complexity.
     * The left pointer starts from the beginning of the array and moves right,
     * while the right pointer starts from the end of the array and moves left.
     * When both pointers point to elements that are out of order (left is positive and right
     * is negative), they swap the elements. The process continues until the left pointer
     * is less than the right pointer.
     * 
     * Algorithm:
     * 1. Initialize two pointers, left at the start of the array and right at the end.
     * 2. While left is less than right:
     *    a. If the element at the left pointer is negative, increment the left pointer.
     *    b. If the element at the right pointer is positive, decrement the right pointer.
     *    c. If the element at the left pointer is positive and the element at the
     *       right pointer is negative, swap the elements and move both pointers inward.
     * 3. Continue this process until the left pointer is no longer less than the right pointer.
     * 4. Print the rearranged array.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {-1,-2,1,-2,4,-5,6,7,8,-10,12,-3};

        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]<0) {
                left++;
            } else if(arr[right]>0) {
                right--;
            } else{
                swap(arr,left,right);
                left++;
                right--;
            }
        }

        for(int i:arr) {
            System.out.print(i+" ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
