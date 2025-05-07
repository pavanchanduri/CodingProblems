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

    private static String compress(String str) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (stack.isEmpty() || ch == stack.peek()) {
                stack.push(ch);
            } else {
                if(ch != stack.peek()) {
                    int size = stack.size();
                    result.append(size);
                    result.append(stack.pop());
                    stack.clear();
                }
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
}
