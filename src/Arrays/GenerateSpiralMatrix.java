package Arrays;

import java.util.Scanner;

public class GenerateSpiralMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];
        int rMin = 0, rMax = n-1, cMin = 0, cMax = n-1;
        int count = 0;

        while(count < Math.pow(n, 2)) {

            for(int col = cMin; col <= cMax && count < Math.pow(n,2); col++ ) {
                count++;
                arr[rMin][col] = count;
            }
            rMin++;
            for(int row = rMin; row <= rMax && count < Math.pow(n,2); row++) {
                count++;
                arr[row][cMax] = count;
            }
            cMax--;
            for(int col = cMax; col >= cMin && count < Math.pow(n,2); col--) {
                count++;
                arr[rMax][col] = count;
            }
            rMax--;
            for(int row = rMax; row >= rMin && count < Math.pow(n,2); row--) {
                count++;
                arr[row][cMin] = count;
            }
            cMin++;
        }

        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
}
