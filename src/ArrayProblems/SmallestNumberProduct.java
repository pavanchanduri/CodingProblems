package ArrayProblems;

public class SmallestNumberProduct {

    public static void main(String[] args) {
        String result = smallestNumberProduct(12000);
        System.out.println(result);
    }

    /**
     * This method finds the smallest number whose digits multiply to a given number n.
     * If no such number exists, it returns "-1".
     * The algorithm works as follows:
     * 1. Start with the largest digit (9) and work down to 2.
     * 2. For each digit, check if it divides n evenly.
     * 3. If it does, divide n by that digit and prepend the digit to the result string.
     * 4. Continue this process until n is reduced to 1 or no more digits are left.
     * 5. If n is not 1 at the end, return "-1" as it's not possible to form such a number.
     * 6. Otherwise, return the formed number as a string.
     * 
     * @param n The target product of digits
     * @return The smallest number whose digits multiply to n, or "-1" if not possible.
     */
    public static String smallestNumberProduct(int n) {
        String ans = "";
        for (int div = 9; div >= 2; div--) {
            while (n % div == 0) {
                n /= div;
                ans = div + ans;
            }
        }
        return n != 1 ? "-1" : ans;
    }
}