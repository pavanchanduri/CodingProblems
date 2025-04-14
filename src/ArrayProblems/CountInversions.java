package ArrayProblems;


import java.util.ArrayList;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        int inversionCount = mergeSort(arr,0,arr.length-1);

        System.out.println(inversionCount);
    }

    private static int mergeSort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            int leftInversionCount = mergeSort(arr, start, mid);
            int rightInversionCount = mergeSort(arr, mid + 1, end);
            int inversionCount = merge(arr, start, mid, end);

            return inversionCount + leftInversionCount + rightInversionCount;
        }
        return 0;
    }

    private static int merge(int[] arr, int start, int mid, int end) {

        ArrayList<Integer> temp = new ArrayList<>();
        int inversionCount = 0;
        int i = start, j = mid + 1;
        while(i<=mid && j<=end) {
            if(arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else if(arr[i] > arr[j]) {
                temp.add(arr[j]);
                j++;
                inversionCount+=mid-i+1; //When arr[i]>arr[j], all elements from i till mid are also more than arr[j]
            }
        }
        while(i<=mid) {
            temp.add(arr[i]);
            i++;
        }
        while(j<=end) {
            temp.add(arr[j]);
            j++;
        }

        for(int idx=start;idx<=end;idx++) {
            arr[idx] = temp.get(idx-start);
        }
        return inversionCount;
    }
}
