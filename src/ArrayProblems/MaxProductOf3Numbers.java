package ArrayProblems;

public class MaxProductOf3Numbers {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {

        if(nums.length==3) {
            if(nums[0]==0||nums[1]==0||nums[2]==0) {
                return 0;
            }
        }

        if(nums[1]==0&&nums.length==4) {
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
