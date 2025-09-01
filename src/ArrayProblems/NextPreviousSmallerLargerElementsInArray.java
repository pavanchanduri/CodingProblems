package ArrayProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextPreviousSmallerLargerElementsInArray {

    public static void main(String[] args) {

        int[] arr = {4,10,5,18,3,12,7};

        int[] result = previousSmallerElement(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();

        result = nextSmallerElement(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();

        result = previousLargerElement(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }
        System.out.println();

        result = nextLargerElement(arr);
        for(int i: result) {
            System.out.print(i+" ");
        }

    }

    /**
     * Find the previous smaller element for each element in the array.
     * The algorithm works by using a stack to keep track of the previous smaller elements.
     * It iterates through the array and for each element, it pops elements from the stack
     * until it finds an element smaller than the current element.
     * @param arr The input array.
     * @return An array containing the previous smaller elements.
     */
    private static int[] previousSmallerElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        for(int i=0;i<arr.length;i++) {
            while(!stack.isEmpty() && stack.peek()>=arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    private static int[] nextSmallerElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        for(int i=arr.length-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek()>=arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    private static int[] previousLargerElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        for(int i=0;i<arr.length;i++) {
            while(!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    private static int[] nextLargerElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);

        for(int i=arr.length-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek()<=arr[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }
}
