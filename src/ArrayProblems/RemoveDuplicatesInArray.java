package ArrayProblems;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4,5,6,6,7,8,8,9};
        int duplicateCount = 0;
        for(int i = nums.length-1; i>0; i--) {
            if(nums[i]== nums[i-1]) {
                rotateArrayBy1Place(nums, i, nums.length-1);
                duplicateCount++;
            }
        }
        for(int i = 0; i< nums.length-duplicateCount; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    private static void rotateArrayBy1Place(int[] nums, int start, int end) {
        int temp = nums[start];
        for(int i = start; i < end; i++) {
            nums[i] = nums[i+1];
        }
        nums[end] = temp;
    }
}
