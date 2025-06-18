package Strings;

import java.util.Stack;

public class BackspaceStringCompare {

    public static void main(String[] args) {

        String str1 = "#ab#cde#f##xy";
        String str2 = "ab#cc#de#f##xyz#";
        System.out.println(solve(str1).compareTo(solve(str2)) == 0);
    }

    /**
     * This method processes a string that may contain backspace characters ('#').
     * It uses a stack to handle the characters, pushing them onto the stack when they are
     * encountered, and popping the last character when a backspace character is found.
     * After processing the entire string, it constructs a new string from the characters remaining in the stack.
     * 
     * The algorithm works as follows:
     * 1. Initialize an empty stack to hold characters.
     * 2. Iterate through each character in the input string.
     *    - If the character is a backspace ('#') and the stack is empty, ignore it.
     *    - If the character is a backspace ('#'), pop the last character from the stack (if the stack is not empty).
     *    - If the character is not a backspace, push it onto the stack.
     * 3. After processing all characters, construct a new string from the characters in the stack.
     * 4. Return the constructed string as a StringBuilder.
     * 
     * @param str the input string to process
     *            which may contain backspace characters ('#')
     * @return a StringBuilder containing the processed string
     */
    private static StringBuilder solve(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '#' && stack.isEmpty()) {
                continue; // Ignore backspace if stack is empty
            }
            if (c == '#' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result;
    }
}
