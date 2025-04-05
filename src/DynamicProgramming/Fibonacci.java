package DynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
    static int[] memo;

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        memo = new int[n+1];

        System.out.println(fibonacciBottomUp(n));
    }

    private static int fibonacciRecursive(int n) {

        if(n==1 || n==2) {
            return 1;
        }
        else {
            return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
        }
    }

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
