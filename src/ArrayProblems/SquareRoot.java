package ArrayProblems;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        int number = new Scanner(System.in).nextInt();
        int sqrt = findSquareRoot(number);
        System.out.println("Square root of " + number + " is: " + sqrt);
    }

    public static int findSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }

        int start = 0, end = number, result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Check if mid is a valid square root
            if (mid * mid == number) {
                return mid;
            }

            // If mid*mid is less than the number, move to the right half
            if (mid * mid < number) {
                result = mid; // Update result to the closest lower value
                start = mid + 1;
            } else {
                // If mid*mid is greater than the number, move to the left half
                end = mid - 1;
            }
        }

        return result; // Return the floor value of the square root
    }
}
