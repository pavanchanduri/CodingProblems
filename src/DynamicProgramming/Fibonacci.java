package DynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
    static int[] memo;

    public static void main(String[] args) {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }
        memo = new int[n+1];

        System.out.println(fibonacciBottomUp(n));
        // Example usage of fibonacciRecursive to avoid unused method warning
        System.out.println("Recursive: " + fibonacciRecursive(n));
        // Example usage of fibonacciMemoization to avoid unused method warning
        memo = new int[n+1];
        System.out.println("Memoization: " + fibonacciMemoization(n));
    }

    /**
     * Recursive approach to calculate fibonacci number
     * @param n - Number for which fibonacci is to be calculated
     * @return - Fibonacci number for the inputted integer
     */
    private static int fibonacciRecursive(int n) {

        if(n==1 || n==2) {
            return 1;
        }
        else {
            return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
        }
    }

    /**
     * Memoization technique
     * Store intermediate results in an array and return the result in the memo array
     * @param n - Number for which fibonacci is to be calculated
     * @return - Fibonacci number for the inputted integer
     */
    private static int fibonacciMemoization(int n) {

        if(memo[n] != 0) return memo[n];
        if(n == 1 || n == 2) {
            memo[n] = 1;
        }
        else {
            memo[n] = fibonacciMemoization(n-1) + fibonacciMemoization(n-2);
        }
        return memo[n];
    }

    /**
     * Bottom up technique in Dynamic Programming where you store the results in an array
     * @param n - Number for which fibonacci is to be calculated
     * @return - Fibonacci number for the inputted integer
     */
    private static int fibonacciBottomUp(int n) {

        if(n == 1 || n == 2) {
            return 1;
        }
        int[] bottomUp = new int[n+1];
        bottomUp[0] = 0;
        bottomUp[1] = 1;
        for(int i = 2; i <= n; i++) {
            bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
        }
        return bottomUp[n];
    }
}
