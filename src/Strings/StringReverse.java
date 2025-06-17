package Strings;

/**
 * This class demonstrates how to reverse a string using a two-pointer approach.
 * It converts the string into a character array, then swaps characters from the
 * beginning and end of the array until they meet in the middle.
 * 
 * The algorithm works as follows:
 * 1. Convert the string to a character array.
 * 2. Initialize two pointers: one at the start (left) and one at the end (right) of the array.
 * 3. Swap characters at these pointers and move the pointers towards each other.
 * 4. Continue until the left pointer is no longer less than the right pointer.
 * 5. Convert the character array back to a string and print it.
 */
public class StringReverse {
    public static void main(String[] args) {
        String s1 = "This is a string";

        char[] words = s1.toCharArray();
        int left = 0, right = words.length - 1;
        while (left < right) {
            char temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        String s2 = new String(words);
        System.out.println(s2);
    }
}
