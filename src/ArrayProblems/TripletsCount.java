package ArrayProblems;

import java.util.Arrays;

public class TripletsCount {

    public static void main(String[] args) {
        long[] arr = {5, 1, 3, 4, 7};
        System.out.println(countTriplets(arr.length,12,arr));
    }

    private static long countTriplets(int n, int sum, long arr[]) {
        int count=0;
        Arrays.sort(arr);
        for (int i = 0; i < n-2; i++) {
            int j = i+1, k=n-1;
            while(j<k) {
                //if sum of current triplet is greater than or equal to given sum, decrement k to decrease the sum.
                if(arr[i]+arr[j]+arr[k]>=sum) {
                    k--;
                }
                // if sum of current triplet is less than given sum,
                // then all the elements from j to k will form valid triplets,
                // so add (k-j) to the counter to count all those triplets.
                // then increment j to increase the sum.
                else {
                    count+=(k-j);
                    j++;
                }
            }
        }
        return count;
    }
}
