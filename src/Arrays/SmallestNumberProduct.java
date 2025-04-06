package Arrays;

import java.util.Scanner;

public class SmallestNumberProduct {

    //Generate the Smallest Number whose product is equal to N
    //i.e., if N = 1000, output has to be 5558 i.e., 5X5X5X8 = 1000
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String ans = "";

        for(int div = 9; div>=2; div--) {
            while(n%div == 0) {
                n /= div;
                ans = div+ans;
            }
        }

        if(n!=1) {
            System.out.println("-1");
        } else {
            System.out.println(ans);
        }
    }
}
