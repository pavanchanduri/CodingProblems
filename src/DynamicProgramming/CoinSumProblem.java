package DynamicProgramming;

import java.util.Scanner;

//Link - https://youtu.be/NNcN5X1wsaw?si=z8-ZR5ZZ9UTVX51B
public class CoinSumProblem {

    public static void main(String[] args) {
        int[] coins = {2,5,6,9};
        int sum = new Scanner(System.in).nextInt();
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
        }
        System.out.println(minCoins[sum]);
    }
}
