package ArrayProblems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * If n=5, output has to be [1,2,0] i.e., factorial(5) in the list
 */
public class FactorialsOfLargeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        ArrayList<Integer> factorialDigits = factorial(n);
        System.out.println(factorialDigits);
    }

    /**
     * This method calculates the factorial of a number n and returns it as an ArrayList of integers.
     * The digits of the factorial are stored in reverse order.
     * 
     * The algorithm works as follows:
     * 1. Initialize a BigInteger to hold the factorial value, starting at 1
     * 2. Loop from 2 to n, multiplying the BigInteger by each integer in that range
     * 3. Convert the BigInteger to a string to extract its digits
     * 4. Iterate through the string in reverse order, converting each character to an integer
     *    and adding it to an ArrayList
     * 5. Return the ArrayList containing the digits of the factorial in reverse order
     *
     * @param n The number for which the factorial is to be calculated
     * @return An ArrayList containing the digits of the factorial in reverse order
     */
    private static ArrayList<Integer> factorial(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        BigInteger fact = BigInteger.valueOf(1); // Initialize factorial to 1

        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        String factStr = fact.toString();
        for (int i = 0; i < factStr.length(); i++) {
            result.add(factStr.charAt(i) - '0');
        }
        return result;
    }
}
