package ArrayProblems;

public class SmallestSubArrayWithSumGreaterThanK {
    public static void main(String[] args) {
        int[] arr = {1,10,3,40,18};
        int k = 50;
        System.out.println(smallestSubArrayLength(arr, arr.length, k));
    }

    private static int smallestSubArrayLength(int[] arr, int n, int k) {
        int start = 0, end = 0;
        int currentSum = 0;
        int minLength = arr.length+1;;
        boolean found = false;

        while(end < n) {

            //keep adding until current sum is less than k
            while(currentSum <= k && end < n) {
                currentSum += arr[end++];
            }

            while(currentSum > k && start < n) {
                found = true;
                if(end-start < minLength) {
                    minLength = end-start;
                }
                currentSum -= arr[start++];
            }
        }
        if(found) {
            return minLength;
        }
        return 0;
    }
}
