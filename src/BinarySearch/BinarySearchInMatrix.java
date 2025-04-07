package BinarySearch;

import java.util.Scanner;

/**
1. Idea here is to start with searching with the last element in the first row
2. Decrement the column pointer if the target element is less than the last element in row 1
3. Increment the row pointer and do the same operation as above if the target element is more than the last element in row1
*/
public class BinarySearchInMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {4,5,6,8},
                {9,10,11,12},
                {13,14,15,16}};

        int target = new Scanner(System.in).nextInt();
        int i=0,j=arr[0].length-1;

        while (i<arr.length && j>=0){
            if(arr[i][j] == target){
                System.out.println("Target found at ["+(i+1)+","+(j+1)+"]");
                System.exit(0);
            } else if(arr[i][j]>target){
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Target element "+target+" is not found");
    }
}
