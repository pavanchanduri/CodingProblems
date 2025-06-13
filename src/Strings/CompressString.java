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
