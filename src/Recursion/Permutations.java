package Recursion;

/**
 1. Fix an index and keep recursively calling permutations function in the loop
 */
public class Permutations {

    public static void main(String[] args) {

        String str = "ABC";
        char[] chars = str.toCharArray();
        permutations(chars, 0);

    }

    private static void permutations(char[] chars, int fixedIndex) {

        if(fixedIndex == chars.length-1) {
            System.out.println(chars);
            return;
        }
        for(int i = fixedIndex; i < chars.length; i++) {
            swap(chars, fixedIndex, i);
            permutations(chars, fixedIndex+1);
            swap(chars, fixedIndex, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
