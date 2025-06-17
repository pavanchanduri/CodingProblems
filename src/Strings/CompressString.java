package Strings;

import java.util.Stack;

/**
 * If the string is aaabbccaaaddddefg, print 3a2b2c3a4d1e1f1g
 */
public class CompressString {
    public static void main(String[] args) {
        String str = "aaabbccaaaddddefg";
        System.out.println(compress(str));
    }

    /**
     * This method compresses a string by replacing consecutive identical characters
     * with the character followed by the number of occurrences.
     * For example, "aaabbccaaaddddefg" becomes "3a2b2c3a4d1e1f1g". 
     * It uses a stack to keep track of the current character sequence.
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
        //After all the iterations if the stack is still not Empty
        //Implies that there are identical characters in the stack
        //Pop and append the size to the result
        if(!stack.isEmpty()) {
            int size = stack.size();
            result.append(size);
            result.append(stack.pop());
        }

        return result.toString();
    }
}
