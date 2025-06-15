package ArrayProblems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * If n=5, output has to be [1,2,0] i.e., factorial(5) in the list
 */
public class FactorialsOfLargeNumbers {

    public static void main(String[] args) {

        BigInteger factorial = BigInteger.valueOf(1);
        ArrayList<Integer> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        for(int i=1;i<=n;i++) {
            factorial=factorial.multiply(BigInteger.valueOf(i));
        }

        StringBuilder str = new StringBuilder();
        while(factorial.compareTo(BigInteger.ZERO)!=0) { //equivalent to factorial>0
            BigInteger rem = factorial.remainder(BigInteger.TEN); //equivalent to factorial%10
            factorial = factorial.divide(BigInteger.TEN); //equivalent to factorial/10
            str.insert(0, rem); //equivalent to str = rem+str
        }

        for(int i=0;i<str.length();i++) {
            result.add(str.charAt(i)-'0');
        }
        System.out.println(result);
    }
}
