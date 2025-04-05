package Arrays;

import java.util.Scanner;

public class SmallestNumberProduct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder ans = new StringBuilder();

        for(int div = 9; div>=2; div--) {
            while(n%div == 0) {
                n /= div;
                ans.insert(0, div);
            }
        }

        if(n!=1) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }
    }
}
