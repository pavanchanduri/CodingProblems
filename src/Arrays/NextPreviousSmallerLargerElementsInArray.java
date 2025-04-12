package Arrays;

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
