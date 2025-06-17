package Strings;

/**
 1. Fix an index and keep recursively calling permutations function in the loop
 */
public class Permutations {

    public static void main(String[] args) {

        String str = "ABC";
        char[] chars = str.toCharArray();
        permutations(chars, 0);

    }

    /**
     * Generate all permutations of the given character array.
     * This function fixes an index and recursively generates permutations
     * for the remaining characters.
     * * The base case is when the fixed index reaches the last character,
     *  in which case it prints the current permutation.
     * 
     *  The algorithm works as follows:
     *  1. If the fixed index is the last index of the character array,
     *    print the current permutation.
     *  2. Loop through the character array starting from the fixed index.
     *  3. For each character, swap it with the character at the fixed index.
     *  4. Recursively call the permutations function with the next index (fixedIndex + 1).
     *  5. After the recursive call, swap the characters back to restore the original order.
     *
     * @param chars Character array representing the string to permute.
     * @param fixedIndex The index that is currently fixed for permutation.
     *                   
     */
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
