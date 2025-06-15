package ArrayProblems;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int number = scanner.nextInt();
            int sqrt = findSquareRoot(number);
            System.out.println("Square root of " + number + " is: " + sqrt);
        }
    }

    public static int findSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }

        if(number == 0) return 0;

        if(number == 1) return 1;

        int start = 0, end = number;

        while (start <= end) {
            int mid = start + (end-start) / 2;

            // Check if mid is a valid square root
            if (mid == number/mid) {
                return mid;
            }

            // If mid*mid is less than the number, move to the right half
            if (mid < number/mid) {
                start = mid + 1;
            } else {
                // If mid*mid is greater than the number, move to the left half
                end = mid - 1;
            }
        }

        return end; // Return the floor value of the square root
    }
}
