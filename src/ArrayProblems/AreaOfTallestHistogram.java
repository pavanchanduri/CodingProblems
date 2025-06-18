package ArrayProblems;

import java.util.Arrays;
import java.util.Stack;

public class AreaOfTallestHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    /**
     * Find the largest rectangle area in a histogram represented by heights.
     * The histogram is represented as an array of integers where each integer represents the height of a bar.
     * The width of each bar is considered to be 1.
     * The algorithm uses a stack to find the next and previous smaller elements for each bar,
     * which helps in calculating the maximum area of the rectangle that can be formed with each bar.
     * 
     * The Algorithm works as follows:
     * 1. Initialize a variable to keep track of the maximum area.
     * 2. If the heights array has only one element, return that height as the
     *    area.
     * 3. Use the `nextSmallerElement` method to find the next smaller element for each bar.
     * 4. Use the `previousSmallerElement` method to find the previous smaller
     *    element for each bar.
     * 5. Iterate through each bar in the histogram:
     *    a. Calculate the area of the rectangle that can be formed with the current bar
     *       by multiplying its height with the width, which is determined by the indices of the next and previous smaller elements.
     *    b. Update the maximum area if the calculated area is larger than the current maximum area.
     * 6. Return the maximum area found.
     * 
     * @param heights the heights of the histogram bars
     * @return the largest rectangle area
     */
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0, area;

        if(heights.length==1) {
            return heights[0];
        }

        //Read the smaller elements on either side which is where we need to limit our width to
        int[] right = nextSmallerElement(heights);
        int[] left = previousSmallerElement(heights);

        for(int i=0;i<heights.length;i++) {
            area = heights[i] * (right[i]-left[i]-1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    /**
     * Find the next smaller element for each bar in the histogram.
     * This method uses a stack to efficiently find the next smaller element for each height.
     * The next smaller element is the index of the first bar to the right that is shorter than the current bar.
     * If no such element exists, the index is set to the length of the heights array.
     * 
     * The Algorithm works as follows:
     * 1. Initialize a stack to keep track of indices of the histogram bars.
     * 2. Iterate through the heights array from right to left.
     * 3. For each height, pop elements from the stack until the top of the stack is less than the current height.
     * 4. If the stack is empty, it means there is no smaller element to the right, so set the current index to the length of the heights array.
     * 5. If the stack is not empty, the top of the stack is the index of the next smaller element.
     * 6. Push the current index onto the stack.
     * 
     * @param heights the heights of the histogram bars
     * @return an array where each element is the index of the next smaller bar
     *         or the length of the heights array if no smaller bar exists
     */
    private static int[] nextSmallerElement(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int[] right = new int[heights.length];
        Arrays.fill(right, -1);

        for(int i=heights.length-1;i>=0;i--) {
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) {
                stack.pop();
            }
            //Setting arr.length as the boundary in cases where there is no min element on the right side
            right[i] = stack.isEmpty()?heights.length:stack.peek();
            stack.push(i);
        }
        return right;
    }

    /**
     * Find the previous smaller element for each bar in the histogram.
     * This method uses a stack to efficiently find the previous smaller element for each height.
     * The previous smaller element is the index of the first bar to the left that is shorter than the current bar.
     * If no such element exists, the index is set to -1.
     * 
     * The Algorithm works as follows:
     * 1. Initialize a stack to keep track of indices of the histogram bars.
     * 2. Iterate through the heights array from left to right.
     * 3. For each height, pop elements from the stack until the top of the
     *    stack is less than the current height.
     * 4. If the stack is empty, it means there is no smaller element to the left,
     * so set the current index to -1.
     * 5. If the stack is not empty, the top of the stack is the index of the previous smaller element.
     * 6. Push the current index onto the stack.
     * 
     * @param heights the heights of the histogram bars
     * @return an array where each element is the index of the previous smaller bar
     *         or -1 if no smaller bar exists
     */
    private static int[] previousSmallerElement(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[heights.length];
        Arrays.fill(left, -1);

        for(int i = 0; i< heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]) {
                stack.pop();
            }
           left[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        return left;
    }
}
