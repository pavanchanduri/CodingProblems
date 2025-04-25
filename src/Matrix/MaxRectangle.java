package Matrix;

import java.util.Arrays;
import java.util.Stack;

/**
 * 1. We use the same approach that is used in AreaOfTallestHistogram
 * 2. For each and every row, add the previous row contents if its 1
 */
public class MaxRectangle {

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 1, 0},
                          {1, 1, 1, 1},
                          {1, 1, 1, 1},
                          {1, 1, 0, 0}};
        System.out.println(maxArea(matrix));
    }

    // Returns area of the largest rectangle with all 1s in mat[][]
    static int maxArea(int[][] mat) {
        int area, maxArea=0;
        int[] height = new int[mat[0].length];
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1) {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }
            area = getMaxArea(height);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }

    static int getMaxArea(int[] heights) {
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
