package ArrayProblems;

public class ArrangePositivesNegatives {

    public static void main(String[] args) {
        int[] arr = {-1,-2,1,-2,4,-5,6,7,8,-10,12,-3};

        int left=0,right=arr.length-1;
        while(left<right){
            if(arr[left]<0) {
                left++;
            } else if(arr[right]>0) {
                right--;
            } else{
                swap(arr,left,right);
                left++;
                right--;
            }
        }

        for(int i:arr) {
            System.out.print(i+" ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
