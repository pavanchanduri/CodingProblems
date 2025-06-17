package Strings;

import java.util.Scanner;
import java.util.Stack;

public class SuperReducedString {

    /**
     * This program reduces a string by removing adjacent matching characters.
     * It uses a stack to keep track of characters and removes them if they match the top
     * character in the stack. If the stack is empty after processing, it prints "Empty
     * String", otherwise it prints the reduced string.
     * 
     * The algorithm works as follows:
     * 1. Read the input string.
     * 2. Initialize an empty stack.
     * 3. Iterate through each character in the string:
     *    - If the stack is empty or the current character does not match the top character
     *      in the stack, push the current character onto the stack.
     *    - If the current character matches the top character in the stack, pop the top
     *      character from the stack.
     * 4. After processing all characters, check if the stack is empty:
     *    - If it is empty, print "Empty String".
     *    - If it is not empty, construct the reduced string from the characters in the
     *      stack and print it. 
     * 
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();

        Stack<Character> stack = new Stack<>();
        for (Character c : str.toCharArray()) {
            if(stack.isEmpty() || c != stack.peek()) {
                stack.push(c);
            } else if(c == stack.peek()){
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack){
            sb.append(ch);
        }

        System.out.println(sb.isEmpty() ? "Empty String" : sb.toString());
    }
}
