package ArrayProblems;

import java.util.Arrays;
import java.util.Stack;


/** Leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/
 1. For each and every element find the next max element and previous max element.
 2. The difference of the indices would give the width of the rectangle
 3. Multiply the width with height of the bar to get the area
 4. Keep a track of maxArea and compare with area to update it.
 */
public class AreaOfTallestHistogram {

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

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
