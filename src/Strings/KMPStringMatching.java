package Strings;

public class KMPStringMatching {

    public static void main(String[] args) {
        String pattern = "abcdabcefabefabce";
        String str = "abcdaabcabcdabcaabcdabc";
        kmpSearch(pattern, str);
    }

    /**
     * This method implements the Knuth-Morris-Pratt (KMP) algorithm for string matching.
     * It searches for occurrences of a pattern in a given string using the KMP algorithm,
     * which is efficient for finding substrings.
     * 
     * The algorithm works as follows:
     * 1. Preprocess the pattern to create a prefix table that helps in skipping unnecessary comparisons.
     * 2. Iterate through the string, comparing characters with the pattern.
     * 3. If a match is found, print the index where the pattern occurs.
     * 4. If a mismatch occurs, use the prefix table to skip unnecessary comparisons.
     * 
     * @param pattern The substring to search for in the string.
     * @param str The string in which to search for the pattern.
     */
    private static void kmpSearch(String pattern, String str) {
        int lp = pattern.length();
        int ls = str.length();
        int[] table = new int[lp];
        int j=0;
        prefixTable(pattern, lp, table);
        int i=0;
        while(i<ls) {
            if(str.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
            }
            if(j==lp) {
                System.out.println("Pattern " + pattern + " found at index " + (i-j));
                j = table[j-1];
            } else if(i<ls && str.charAt(i)!=pattern.charAt(j)) {
                if(j!=0) {
                    j = table[j-1];
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * This method constructs the prefix table for the KMP algorithm.
     * The prefix table is used to skip unnecessary comparisons when a mismatch occurs.
     * 
     * The algorithm works as follows:
     * 1. Initialize two pointers: j for the length of the previous longest prefix suffix,
     *    and i for the current character in the pattern.
     * 2. Iterate through the pattern, updating the prefix table based on matches and mismatches.
     * 
     * @param pattern The pattern for which to create the prefix table.
     * @param m The length of the pattern.
     * @param table The array to store the prefix table.
     */
    private static void prefixTable(String pattern, int m, int[] table) {
        int j=0, i=1;
        while(i<m) {
            if(pattern.charAt(i)==pattern.charAt(j)) {
                j++;
                table[i]=j;
                i++;
            } else {
                if(j!=0) {
                    j = table[j-1];
                } else { //len == 0
                    table[i]=j;
                    i++;
                }
            }
        }
    }
}
