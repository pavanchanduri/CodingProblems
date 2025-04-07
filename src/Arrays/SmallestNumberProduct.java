package Arrays;

import java.util.Scanner;

/**
1. Generate the Smallest Number whose product is equal to N
   i.e., if N = 1000, output has to be 5558 i.e., 5X5X5X8 = 1000
2. Start a loop with divisor as 9 till 2 and divide the number with the divisor
3. Loop till the remainder becomes zero and append the number of times divisor was used to the answer string
4. If the number becomes 1 -> we found the answer or else return -1
 **/
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
