package ArrayProblems;

import java.util.Scanner;
import java.util.Arrays;

/**
 1. Find minimum among arr[0]+k and arr[i]-k
 2. Find maximum among arr[n-1]-k and arr[i-1]+k
 3. Find the minimum result among existing result and max-min
 */
public class MinimizeHeights {

    public static void main(String[] args) {
        int[] arr = {3, 9, 12, 16, 20};
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Arrays.sort(arr);
        int n = arr.length;
        int minimum = arr[0];
        int maximum = arr[n-1];
        int result = maximum-minimum;

        for(int i=1;i<n;i++){
            minimum = Math.min(arr[0]+k, arr[i]-k);
            maximum = Math.max(arr[n-1]-k, arr[i-1]+k);
            if(minimum<0) continue;
            result = Math.min(result, maximum - minimum);
        System.out.println(result);
        scanner.close();
        }
    }
}
