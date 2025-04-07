package Arrays;

import java.util.Arrays;

/**
 1. Sort the array and start an iteration till arr.length-1
 2. Fix i pointer and take j -> i+1 and k->n-1
 3. While j<k, keep checking arr[j]+arr[k] == target-arr[i] and return i,j,k as a triplet
 4. In case if arr[j] == arr[j+1], increment j to avoid duplicate pairs
 5. In case if arr[k] == arr[k-1], decrement k to avoid duplicate pairs
 6. Increment j and decrement k as part of the main loop
 7. As the array is sorted, if arr[j]+arr[k] < target-arr[i], increment j
    as there is no point checking j
 8. If arr[j]+arr[k] > target-arr[i], decrement k as there is no point checking k
 */
public class Triplets {

    public static void main(String[] args) {
        int[] arr = {7,-6,3,8,-1,8,-11};
        int target = 0;
        triplets(arr, target, arr.length);

    }

    public static void triplets(int[] arr, int target, int n) {
        Arrays.sort(arr); //O(nlogn)
        for (int i = 0; i < n; i++) { //O(n)
            if(i==0 || arr[i]!=arr[i-1]) {
                int j = i+1, k=n-1;
                while(j<k) {
                    if(arr[j]+arr[k] == target - arr[i]) {
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                        while(j<k && arr[j] == arr[j+1]) j++;
                        while(j<k && arr[k] == arr[k-1]) k--;
                        j++;
                        k--;
                    } else if(arr[j]+arr[k] < target - arr[i]) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
    }
}
