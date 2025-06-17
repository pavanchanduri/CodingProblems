package Strings;

import java.util.Stack;

/**
 1. '#' key corresponds to backspace and if # is encountered, remove the previous character
 2. Push the characters in to a stack and as and when # is encountered, pop the element
 3. After the stack is completely built, pop all the contents from the stack and build the result string
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {

        String str1 = "ab#cde#f##xy";
        String str2 = "ab#cc#de#f##xyz#";
        System.out.println(solve(str1).compareTo(solve(str2)) == 0);
    }

    /**
     * This method processes a string that may contain backspace characters ('#').
     * It uses a stack to handle the characters, pushing them onto the stack when they are
     * encountered, and popping the last character when a backspace character is found.
     * After processing the entire string, it constructs a new string from the characters remaining in the stack.
     * @param str the input string to process
     *            which may contain backspace characters ('#')
     * @return a StringBuilder containing the processed string
     */
    private static StringBuilder solve(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '#') {
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
