package ArrayProblems;

import java.util.Arrays;

public class LargestNumberFromArray {

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        String[] numStringArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numStringArray[i] = String.valueOf(arr[i]);
        }

        //Sorting happens only if b+a is greater than a+b
        Arrays.sort(numStringArray, (a, b) -> (b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numStringArray.length; i++) {
            sb.append(numStringArray[i]);
        }
        sb = sb.charAt(0)=='0' ? new StringBuilder("0") : sb;
        System.out.println(sb);
    }
}
