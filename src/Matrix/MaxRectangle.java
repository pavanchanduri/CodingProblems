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

    /**
     * Function to find the maximum area of rectangle with all 1s
     * The algorithm works as follows:
     * 1. For each row, we update the height array which keeps track of the
     *    number of consecutive 1s in that column up to that row.
     * 2. We then calculate the maximum area of the histogram represented by
     *    the height array using the getMaxArea function.
     * 3. We keep track of the maximum area found so far and return it at
     *    the end.
     * 
     * @param mat Input binary matrix
     * @return Maximum area of rectangle with all 1s
     */
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

    /**
     * Function to calculate the maximum area of histogram
     * The algorithm works as follows:
     * 1. We find the next smaller element on the right and previous smaller
     *    element on the left for each bar in the histogram.
     * 2. We calculate the area for each bar using the formula:
     *    area = height[i] * (right[i] - left[i] - 1)
     * 3. We keep track of the maximum area found so far and return it at the end.
     * 
     * @param heights Array representing the heights of the histogram bars
     * @return Maximum area of the histogram
     */
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

    /**
     * Function to find the next smaller element on the right for each element in the array
     * The algorithm works as follows:
     * 1. We use a stack to keep track of the indices of the elements in the array.
     * 2. We iterate through the array from right to left.
     * 3. For each element, we pop elements from the stack until we find an element
     *    that is smaller than the current element or the stack becomes empty.
     * 4. If the stack is empty, it means there is no smaller element on the right,
     *    so we set the right boundary to the length of the array.
     * 5. If the stack is not empty, the top element of the stack is the index of the
     *    next smaller element on the right.
     * 6. We push the current index onto the stack and continue to the next element.
     *
     * @param heights Array representing the heights of the histogram bars
     * @return Array representing the indices of the next smaller elements on the right
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
     * Function to find the previous smaller element on the left for each element in the array
     * The algorithm works as follows:
     * 1. We use a stack to keep track of the indices of the elements in the array.
     * 2. We iterate through the array from left to right.
     * 3. For each element, we pop elements from the stack until we find an element
     *    that is smaller than the current element or the stack becomes empty.
     * 4. If the stack is empty, it means there is no smaller element on the left,
     *    so we set the left boundary to -1.
     * 5. If the stack is not empty, the top element of the stack is the index of the
     *    previous smaller element on the left.
     * 6. We push the current index onto the stack and continue to the next element.
     * 
     * @param heights Array representing the heights of the histogram bars
     * @return Array representing the indices of the previous smaller elements on the left
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
