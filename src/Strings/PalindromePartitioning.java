package Strings;

import java.util.*;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        partitionHelper(s, path, res);
        return res;
    }

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
