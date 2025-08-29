package ArrayProblems;

import java.util.Stack;

public class BalancedParentheses {

    public static void main (String[] args) {

        String s="(((()[{}()])))";
        if(isValid(s))
            System.out.println("True");
        else
            System.out.println("False");
    }

    /**
     * This method checks if the given string of parentheses is valid.
     * A string is valid if:
     * 1. Every opening parenthesis has a corresponding closing parenthesis.
     * 2. Parentheses are closed in the correct order.
     * 3. The string does not contain any unmatched parentheses.
     * 
     * The Algorithm works as follows:
     * 1. Initialize an empty stack to keep track of opening parentheses.
     * 2. Iterate through each character in the string:
     *   - If the character is an opening parenthesis ('(', '[', or '{'),
     *     push it onto the stack.
     *   - If the character is a closing parenthesis (')', ']', or '}'):
     *     - Check if the stack is empty. If it is, the string is invalid.
     *     - If the stack is not empty, pop the top element and check if it matches the closing parenthesis.
     *       If it matches, continue; if not, the string is invalid.
     * 3. After processing all characters, check if the stack is empty.
     *    If it is empty, the string is valid; otherwise, it is invalid.
     * 
     * @param s The string containing parentheses to be checked.
     * @return true if the string is valid, false otherwise.
     */
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char it : s.toCharArray()) {
            if (it == '(' || it == '[' || it == '{')
                st.push(it);
            else {
                if(st.isEmpty()) return false; //if there is a closing parenthesis without an opening one
                char ch = st.pop(); // pop the last opening parenthesis
                // Check if the popped character matches the current closing parenthesis
                if((it == ')' && ch == '(') ||  (it == ']' && ch == '[') || (it == '}' && ch == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        // for input like "(((" or "(()", where there are unmatched opening parentheses, this will return false
        // if stack is empty, then the parentheses are balanced
        return st.isEmpty();
    }
}
