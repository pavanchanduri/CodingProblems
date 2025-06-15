package Strings;

import java.util.Scanner;
import java.util.Stack;

/**
 1. If Str = "aaabaxyzzababbba" Output -> abaxyababa i.e., consecutive repeating characters
    i.e., even occurrences to be removed
 2. Initialize a stack and if the stack is empty or the top most element is not
    equal to the next character in the string, push it in to the stack
 3. If the top most element == next character, pop it from the stack
 */
public class SuperReducedString {

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
