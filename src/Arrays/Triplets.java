package Arrays;

import java.util.Arrays;

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
                int tar = target-arr[i];
                while(j<k) {
                    if(arr[j]+arr[k] == tar) {
                        System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
                        while(j<k && arr[j] == arr[j+1]) j++;
                        while(j<k && arr[k] == arr[k-1]) k--;
                        j++;
                        k--;
                    } else if(arr[j]+arr[k] < tar) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
    }
}
