package DynamicProgramming;

import java.util.Scanner;

//Link - https://youtu.be/NNcN5X1wsaw?si=z8-ZR5ZZ9UTVX51B
/**
Using Dynamic Programming tabulation approach
In each iteration, we start with the least denomination coin and then as we progress in the loop,
we compute that coin value + minimum coins [sum-coinValue] i.e., for a sum of 11, we iteratively compute
minimum of minCoins[11] and 1+minCoins[10] as we pick coin value 1 and so on till we use all the coins

----------------------------------------------------------------------------------------
| amount    | [0] | [1] | [2] | [3] | [4] | [5] | [6] | [7] | [8] | [9] | [10] | [11] |
---------------------------------------------------------------------------------------
| Min Coins | 0  |  1  |  2  |  3  |  4  |  1  |  1  |  2  |  3  |  1  |  2   |  3   |
--------------------------------------------------------------------------------------
 */
public class CoinSumProblem {

    public static void main(String[] args) {
        int[] coins = {1,5,6,9};
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int[] minCoins = new int[sum+1];

        if(sum <= 0) {
            System.out.println("0");
            System.exit(0);
        }

        for(int i = 1; i <= sum; i++) {
            minCoins[i] = Integer.MAX_VALUE;

            for(int coin : coins) {
                if(coin <= i && minCoins[i-coin] != Integer.MAX_VALUE) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i-coin]);
                }
            }
        }
        if(minCoins[sum] == Integer.MAX_VALUE) {
            System.out.println("-1");
            System.exit(0);
        System.out.println(minCoins[sum]);
        scanner.close();
    }
}
}
