package ArrayProblems;

import java.util.Arrays;

public class LargestNumberFromArray {

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println("Largest Number Formed: " + formLargestNumber(arr));
    }

    /**
     * This method forms the largest number possible from an array of integers.
     * It sorts the numbers based on their string concatenation results.
     * 
     * The algorithm works as follows:
     * 1. Convert each integer to a string.
     * 2. Sort the strings based on the comparison of concatenated results.
     *    For two strings a and b, compare (b + a) with (a + b).
     * 3. If the largest number is "0", return "0".
     * 4. Concatenate the sorted strings to form the largest number.
     *
     * @param arr The input array of integers.
     * @return The largest number formed as a string.
     */
    private static String formLargestNumber(int[] arr) {
        String[] strArr = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            strArr[i] = String.valueOf(arr[i]);
        }
        
        // Sort the string array based on custom comparison
        // We want to sort such that for two strings a and b,
        // a should come before b if (b + a) is greater than (a + b)
        // This ensures that we get the largest concatenated result
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
        
        if (strArr[0].equals("0")) {
            return "0"; // If the largest number is 0, return "0"
        }
        
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strArr) {
            largestNumber.append(num);
        }
        
        return largestNumber.toString();
    }
}
