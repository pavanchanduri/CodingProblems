package Strings;

public class FindDuplicates {

    public static void main(String[] args) {
        String str = "bcbaabcedffffeeecdfghijklmnopqrstuvwxyz";
        findDuplicates(str);  
    }

    /**
     * This method finds and prints the duplicate characters in a given string.
     * It uses a bucket array to count the frequency of each character.
     * If a character appears more than once, it is printed along with its frequency.
     * 
     * The algorithm works as follows:
     * 1. Create a bucket array of size 256 (assuming ASCII characters).
     * 2. Iterate through the input string and increment the count for each character in the
     *    bucket array.
     * 3. Iterate through the bucket array and print characters that have a count greater than 1,
     *    along with their frequency.
     * 
     * @param str The input string in which to find duplicates.
     *     
     */
    public static void findDuplicates(String str) {
        // Create a bucket array to store the frequency of each character
        int[] frequency = new int[256]; // Assuming ASCII characters

        // Count the frequency of each character in the string
        for (char c : str.toCharArray()) {
            frequency[c]++;
        }

        // Print characters that appear more than once
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 1) {
                System.out.println((char) i + ": " + frequency[i]);
            }
        }
    }
}
