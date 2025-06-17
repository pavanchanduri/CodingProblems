package Strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * This method partitions a string into all possible palindromic substrings.
     * It uses backtracking to explore all combinations of substrings and checks
     * if each substring is a palindrome.
     *
     * The algorithm works as follows:
     * 1. Initialize a result list to store all palindromic partitions.
     * 2. Use a helper function to recursively build partitions.
     * 3. In each recursive call, iterate through the string and extract substrings.
     * 4. Check if the extracted substring is a palindrome.
     * 5. If it is a palindrome, add it to the current path and continue
     *    partitioning the remaining substring.
     * 6. If the remaining substring is empty, add the current path to the result
     *    list as a valid partition.
     * 7. Backtrack by removing the last added substring from the path.
     * 
     * @param s The input string to be partitioned
     * @return A list of lists containing all possible palindromic partitions
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionHelper(s, path, res);
        return res;
    }

    /**
     * This helper method recursively partitions the string into palindromic substrings.
     * It builds the current path of palindromic substrings and adds it to the result
     * list when the entire string has been processed.
     * 
     * The method works as follows:
     * 1. If the remaining substring is empty, add the current path to the result
     *    list as a valid partition.
     * 2. Iterate through the substring, extracting substrings of increasing length.
     * 3. For each substring, check if it is a palindrome.
     * 4. If it is a palindrome, add it to the current path and recursively
     *    call the helper method with the remaining substring.
     * 5. After the recursive call, backtrack by removing the last added substring
     *    from the path to explore other possibilities.
     *
     * @param s The remaining substring to be partitioned
     * @param path The current path of palindromic substrings
     * @param res The result list containing all valid partitions
     */
    static void partitionHelper(String s, List<String> path, List<List<String>> res) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0; i<s.length();++i) {
            String part = s.substring(0, i+1);
            if (isPalindrome(part)) {
                path.add(part);
                partitionHelper(s.substring(i+1), path, res);
                path.remove(part);
            }
        }
    }

    /**
     * This method checks if a given string is a palindrome.
     * A palindrome is a string that reads the same forwards and backwards.
     * 
     * The method works as follows:
     * 1. Initialize two pointers, one at the start and one at the end of the string.
     * 2. Compare characters at both pointers and move them towards the center.
     * 3. If any characters do not match, return false.
     * 4. If all characters match, return true.
     *
     * @param s The string to check
     * @return true if the string is a palindrome, false otherwise
     */
    static boolean isPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> ans = partition(s);
        int n = ans.size();
        System.out.println("The Palindromic partitions are :-");
        System.out.print(" [ ");
        for (int i = 0; i < n; i++) {
            System.out.print("[ ");
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.print("] ");
        }
        System.out.print("]");
    }
}
