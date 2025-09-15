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

    /**
     * This method finds the square root of a given non-negative integer using binary search.
     * It returns the floor value of the square root if the number is not a perfect square.
     * 
     * The algorithm works as follows:
     * 1. Initialize two pointers, start and end, to represent the search range.
     * 2. Use a while loop to perform binary search until start exceeds end.
     * 3. Calculate the mid-point of the current range.
     * 4. Check if mid*mid is equal to the number, if so, return mid.
     * 5. If mid*mid is less than the number, move the start pointer to mid + 1.
     * 6. If mid*mid is greater than the number, move the end pointer to mid - 1.
     * 7. If no exact square root is found, return end which will be the floor value of the square root.
     *
     * @param number The non-negative integer whose square root is to be calculated
     * @return The floor value of the square root
     */
    private static int findSquareRoot(int number) {
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

        // return end as end is the largest integer
        // whose square is less than or equal to n (the floor of the square root).
        return end;
    }
}
