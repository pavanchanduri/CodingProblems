package Strings;

public class RemoveDuplicates {

    public static void main(String[] args) {
        String input = "aabbccddeeffgghh";
        String result = removeDuplicates(input);
        System.out.println("Original: " + input);
        System.out.println("Without duplicates: " + result);
    }

    /**
     * Removes duplicate characters from a string while maintaining the original order of characters.
     * 
     * The algorithm works as follows:
     * 1. Create a boolean array to track seen characters.
     * 2. Iterate through each character in the input string.
     * 3. If the character has not been seen, append it to the result and mark it as seen.
     * 
     * @param str The input string from which duplicates are to be removed.
     * @return A new string with all duplicate characters removed.
     */
    private static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // Assuming ASCII characters

        for (char c : str.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }

        return result.toString();
    }
    
}
