package Strings;

public class MinCharactersFrontForPalindrome {

    public static void main(String[] args) {
        String input = "baacecaaa";
        System.out.println("Minimum characters to add at the front to make it a palindrome: " + minCharactersToAddForPalindrome(input));
    }

    /**
     * This method calculates the minimum number of characters that need to be added
     * at the front of a given string to make it a palindrome.
     * It does this by checking how many characters from the end of the string
     * can be matched with the beginning, and then returns the count of unmatched characters.
     * 
     * The algorithm works as follows:
     * 1. Reverse the input string.
     * 2. For each prefix of the reversed string, concatenate it with the original string
     *    and check if the resulting string is a palindrome.
     * 3. The first prefix that makes the concatenated string a palindrome
     *    determines the number of characters to add at the front.
     *
     * @param input The input string
     * @return The minimum number of characters to add at the front to make it a palindrome
     */
    private static int minCharactersToAddForPalindrome(String input) {
        String reverse = new StringBuilder(input).reverse().toString(); //baaba

        for(int i = 1; i <= reverse.length(); i++){
            String newStr;
            newStr = reverse.substring(0,i)+input;
            if(isPalindrome(newStr)){
                return i; // Return the number of characters added to the front
            }
        }

        return input.length(); // In the worst case, we need to add all characters
    }

    /**
     * This method checks if a given string is a palindrome.
     * A palindrome is a string that reads the same forwards and backwards.
     * 
     * @param str The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    private static boolean isPalindrome(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return true;
        } else {
            String reverse = new StringBuilder(str).reverse().toString();
            return str.equals(reverse);
        }
    }
}
