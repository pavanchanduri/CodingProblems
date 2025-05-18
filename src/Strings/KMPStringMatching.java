package Strings;

public class KMPStringMatching {

    public static void main(String[] args) {
        String pattern = "abcdabcefabefabce";
        String str = "abcdaabcabcdabcaabcdabc";
        kmpSearch(pattern, str);
    }

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
