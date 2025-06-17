package Strings;

/**
 * This class implements a simple string pattern matching algorithm.
 * It searches for a specified pattern within a given text and prints the starting index
 * of each occurrence of the pattern in the text.
 * 
 * The algorithm works by iterating through the text and checking if the first character of the
 * pattern matches the current character in the text. If it does, it checks if the substring
 * from the current index in the text matches the entire pattern. If it does, it prints
 * the index of the match.
 */
public class StringPatternMatching {

    public static void main(String[] args) {
        String text = "AABAACAADAABAABAAB";
        String pattern = "AABA";

        for(int i=0; i<text.length(); i++){
            if(pattern.charAt(0) == text.charAt(i)) {
                if (((i + pattern.length()) <= text.length()) &&
                        pattern.equals(text.substring(i, i + pattern.length()))) {
                    System.out.println(i);
                }
            }
        }
    }
}
