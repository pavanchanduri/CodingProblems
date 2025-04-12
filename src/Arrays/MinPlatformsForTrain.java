package Arrays;

import java.util.Arrays;

/**
 1. Idea here is to sort the arrays and as arr[i] < dep[j]
    implies train has not left and count gets incremented
 */
public class MinPlatformsForTrain {

    public static void main(String[] args) {

        double[] arr = {9, 9.75, 9.9, 11, 15, 18};
        double[] dep = {9.3, 12, 11.5, 11.9, 19, 20};

        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int count = 0;
        int maxCount = 0;

        while(i<arr.length) {
            if(arr[i]<=dep[j]) {
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            } else if(arr[i]>dep[j]) {
                count--;
                j++;
            }
        }
        System.out.println(maxCount);
    }
}
