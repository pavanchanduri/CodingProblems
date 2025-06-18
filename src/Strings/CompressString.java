package Strings;

import java.util.Stack;

/**
 * If the string is aaabbccaaaddddefg, print 3a2b2c3a4d1e1f1g
 */
public class CompressString {
    public static void main(String[] args) {
        String str = "aaabbccaaaddddefg";
        System.out.println(compress(str));
        System.out.println(compress2(str));
    }

    /**
     * This method compresses a string by replacing consecutive identical characters
     * with the character followed by the number of occurrences.
     * For example, "aaabbccaaaddddefg" becomes "3a2b2c3a4d1e1f1g". 
     * It uses a stack to keep track of the current character sequence.
     * 
     * The algorithm works as follows:
     * 1. Iterate through each character in the string.
     * 2. If the stack is empty or the current character matches the top of the stack,
     *    push the character onto the stack.
     * 3. If the current character does not match the top of the stack,
     *    pop the top character from the stack, append its count to the result,
     *    and clear the stack.
     * 4. Push the current character onto the stack.
     * 5. After processing all characters, if the stack is not empty,
     *    pop the remaining character from the stack and append its count to the result.
     * 
     * @param str the input string to compress
     *           (assumed to be non-empty and contain only lowercase letters)
     * @return the compressed string
     */
    private static String compress(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty() || ch == stack.peek()) {
                stack.push(ch);
            } else {
                //When the current char doesn't match
                //Pop the char and append size to the result
                if(ch != stack.peek()) {
                    int size = stack.size();
                    result.append(size);
                    result.append(stack.pop());
                    stack.clear();
                }
                //Push the new character to the stack
                stack.push(ch);
            }
        }
        if(!stack.isEmpty()) {
            int size = stack.size();
            result.append(size);
            result.append(stack.pop());
        }

        return result.toString();
    }

    /**
     *
     * The algorithm works as follows:
     * 1. Initialize a count variable to 1.
     * 2. Iterate through the string starting from the second character.
     * 3. If the current character matches the previous one, increment the count.
     * 4. If it does not match, append the count and the previous character to the result,
     *    then reset the count to 1.
     * 5. After the loop, append the last character and its count to the result.
     *
     * @param str the input string to compress
     * @return the compressed string
     */
    // This is a more efficient version without using a stack
    // It directly counts consecutive characters and builds the result string.
    // This method is more straightforward and avoids the overhead of using a stack.
    // It is also easier to understand and maintain.
    // This method is more efficient than the previous one.
    // It has a time complexity of O(n) and a space complexity of O(n).
    // It is a good choice for compressing strings with many consecutive characters.
    private static String compress2(String str) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }
        // Append the last character and its count
        result.append(count).append(str.charAt(str.length() - 1));
        return result.toString();
    }
}
