package ArrayProblems;

import java.util.*;

public class PrimeSplitCounter {
    private static final int MAXV = 1_000_000;
    private static boolean[] isPrime;

    public static void main(String[] args) {
        sieve(); // initialize primes

        // Example 1
        String s1 = "11375";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + countPrimeSplits(s1)); // Expected 3

        // Example 2
        String s2 = "3175";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + countPrimeSplits(s2)); // Expected 3
    }

    // Precompute primes using Sieve of Eratosthenes
    private static void sieve() {
        isPrime = new boolean[MAXV + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int p = 2; p * p <= MAXV; p++) {
            if (isPrime[p]) {
                for (int multiple = p * p; multiple <= MAXV; multiple += p) {
                    isPrime[multiple] = false;
                }
            }
        }
    }

    public static int countPrimeSplits(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // base case: one way to parse empty suffix

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0; // no prime can start with 0
                continue;
            }

            long val = 0;
            // Build numbers up to length 7 (since 10^6 has 7 digits)
            for (int j = i; j < Math.min(n, i + 7); j++) {
                val = val * 10 + (s.charAt(j) - '0');
                if (val > MAXV) break;

                if (val >= 2 && isPrime[(int) val]) {
                    dp[i] += dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}
