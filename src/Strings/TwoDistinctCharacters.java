package Strings;

public class TwoDistinctCharacters {

    /**
     * This program finds the maximum length of a substring that contains
     * exactly two distinct characters. It uses a 2D array to keep track of
     * pairs of characters and their counts. The algorithm iterates through
     * the input string, updating the counts for each character pair. Finally,
     * it finds the maximum count from the 2D array and prints it.  
     * 
     * The algorithm works as follows:
     * 1. Initialize a 2D array `pair` to keep track of character pairs.
     * 2. Initialize a 2D array `count` to keep track of the counts of each character pair.
     * 3. Iterate through each character in the input string:
     *    - For each character, update the `pair` and `count` arrays for all possible pairs.
     *    - If a character matches the current pair, set its count to -1 (indicating a duplicate).
     *    - If the count is not -1, increment the count for that character pair.
     * 4. After processing all characters, find the maximum count from the `count` array.
     * 
     * @param args Command line arguments (not used).
     * @return The maximum length of a substring with exactly two distinct characters.
     */
    public static void main(String[] args) {

        String str = "beabeefeab";

//        if(str.length() <= 1) {
//            System.out.println(0);
//            System.exit(0);
//        }

        int[][] pair = new int[26][26];
        int[][] count = new int[26][26];

        for(int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            int letterNum = letter - 'a';

            for(int col = 0; col < 26; col++) {
                if(pair[letterNum][col] == letter) {
                    count[letterNum][col] = -1;
                }
                if(count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }

            for(int row = 0; row < 26; row++) {
                if(pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if(count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }

        int max = 0;
        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < 26; j++) {
                max = Math.max(max, count[i][j]);
            }
        }
        System.out.println(max);
    }
}
