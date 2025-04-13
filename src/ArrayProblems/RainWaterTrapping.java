package ArrayProblems;

/** LeetCode https://leetcode.com/problems/trapping-rain-water/description/
 1. Take two pointers @ 0 and height.length - 1 and at each and every bar,
    keep finding the left Max and Right Max element
 2. Pick the max element that is less among right and left and that would give the limit
 3. leftMax - height[i] gives the area that a given tower can accommodate if leftMax is less
 4. Same as step3 for rightMax.
 */
public class RainWaterTrapping {

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int area = 0;

        if(height.length == 1) {
            return 0;
        }

        int left = 0, right = height.length-1;
        int leftMax = 0, rightMax = 0;
        while(left<right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax<rightMax) {
                area+=leftMax-height[left];
                left++;
            } else {
                area+=rightMax-height[right];
                right--;
            }
        }
        return area;
    }
}
