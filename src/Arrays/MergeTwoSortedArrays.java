package Arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9,13,14,15};
        int[] arr2 = {2,4,6,8,10,12,14,15,16,17};

        int[] mergedArray = new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i<arr1.length && j<arr2.length) {
            if (arr1[i] < arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else if (arr1[i] > arr2[j]) {
                mergedArray[k++] = arr2[j++];
            } else {
                mergedArray[k++] = arr1[i++];
                mergedArray[k++] = arr2[j++];
            }
        }

        //Copy rest of the elements from arr1
        while(i<arr1.length) {
            mergedArray[k++] = arr1[i++];
        }

        while(j<arr2.length) {
            mergedArray[k++] = arr2[j++];
        }
        for(int num:mergedArray)
        {
            System.out.print(num+" ");
        }
    }
}
