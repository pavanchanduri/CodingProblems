package ArrayProblems;

import java.util.Stack;
import java.util.Arrays;

/**
 1. Find out elements that are smaller on the right side and larger on the left side
 2. If the rightIndex is arr.length and leftIndex is -1 => Pivot Element
 */
public class PivotElement {

    public static void main(String[] args) {
        int[] arr = {-1,2,-5,-3,16,21,32,26,64,99};

        int[] rightSmallerElements = rightSmallerElements(arr);
        int[] leftLargerElements = leftLargerElements(arr);

        for(int i=0;i<arr.length;i++) {
            if(rightSmallerElements[i] == arr.length && leftLargerElements[i] == -1) {
                System.out.print(arr[i]+" ");
            }
        }
    }

    private static int[] rightSmallerElements(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] rightSmallerElements = new int[arr.length];
        Arrays.fill(rightSmallerElements, -1);

        for(int i=arr.length-1;i>=0;i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            rightSmallerElements[i] = stack.isEmpty()?arr.length:stack.peek();
            stack.push(i);
        }
        return rightSmallerElements;
    }

    private static int[] leftLargerElements(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] leftLargerElements = new int[arr.length];
        Arrays.fill(leftLargerElements, -1);

        for(int i=0;i<arr.length;i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            leftLargerElements[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return leftLargerElements;
    }
}
