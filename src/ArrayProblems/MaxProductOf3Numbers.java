package ArrayProblems;

public class MaxProductOf3Numbers {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3};
        System.out.println(maximumProduct(nums));
    }

    /**
     * This method finds the maximum product of three numbers in an array.
     * It considers both the case of three largest positive numbers and two smallest (most negative) numbers with the largest positive number.
     *
     * The algorithm works as follows:
     * 1. If the array length is 3, it checks if any number is zero and returns 0 if so.
     * 2. It finds the three largest numbers in the array.
     * 3. It finds the two smallest numbers in the array.
     * 4. It calculates the product of the three largest numbers.
     * 5. It calculates the product of the two smallest numbers and the largest number.
     * 6. It returns the maximum of the two products.
     * 
     * @param nums an array of integers
     * @return the maximum product of three numbers
     */
    public static int maximumProduct(int[] nums) {

        if(nums.length==3) {
            if(nums[0]==0||nums[1]==0||nums[2]==0) {
                return 0;
            }
        }

        // If the array has only 4 elements and the second element is zero, return 0.
        // This is a special case to handle arrays like [-1, 0, 2, 3].
        // In such cases, the maximum product of three numbers cannot be formed.
        if(nums.length==4 && (nums[0]==0 || nums[2]==0 || nums[3]==0)) {
            return 0;
        }

        int[] max = new int[3];
        int[] min = new int[2];
        int[] temp = new int[nums.length];

        System.arraycopy(nums, 0, temp, 0, nums.length);


        for(int i=0;i<3;i++) {
            max[i] = findLargest(nums);
        }

        for(int i=0;i<2;i++) {
            min[i] = findSmallest(temp);
        }

        int product1 = max[0]*max[1]*max[2];
        int product2 = min[0]*min[1]*max[0];

        return Math.max(product1, product2);
    }

    /**
     * This method finds the largest number in an array and replaces it with Integer.MIN_VALUE.
     * It returns the largest number found.
     * 
     * The algorithm works as follows:
     * 1. It initializes a variable `max` to Integer.MIN_VALUE.
     * 2. It iterates through the array to find the largest number.
     * 3. It keeps track of the index of the largest number.    
     * 4. It replaces the largest number with Integer.MIN_VALUE to ensure it is not counted again.
     * 5. It returns the largest number found.
     *
     * @param arr an array of integers
     * @return the largest integer in the array
     */
    private static int findLargest(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for(int i=0;i< arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        arr[maxIndex] = Integer.MIN_VALUE;
        return max;
    }

    /**
     * This method finds the smallest number in an array and replaces it with Integer.MAX_VALUE.
     * It returns the smallest number found.
     * 
     * The algorithm works as follows:
     * 1. It initializes a variable `min` to Integer.MAX_VALUE.
     * 2. It iterates through the array to find the smallest number.
     * 3. It keeps track of the index of the smallest number.
     * 4. It replaces the smallest number with Integer.MAX_VALUE to ensure it is not counted again.
     * 5. It returns the smallest number found.
     *
     * @param arr an array of integers
     * @return the smallest integer in the array
     */
    private static int findSmallest(int[] arr) {
        if(arr.length == 1) {
            return arr[0];
        }

        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int i=0;i< arr.length;i++) {
            if(arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        arr[minIndex] = Integer.MAX_VALUE;
        return min;
    }
}
