package Strings;

public class RabinKarpStringMatching {

    private static final int PRIME = 7;

    public static void main(String[] args) {
        String text = "THIS IS A TEST TEXT";
        String pattern = "TEST";
        int index = search(text, pattern);
        if(index == -1){
            System.out.println("Pattern not found");
        } else {
            System.out.println("Pattern found at index " + index);
        }
    }

    /**
     * Calculates the hash value of a string using a polynomial rolling hash function.
     * The hash is calculated as follows:
     * hash = char1 * PRIME^0 + char2 * PRIME^1 + char3 * PRIME^2 + ... + charN * PRIME^(N-1)
     * where PRIME is a constant prime number and charN is the Nth character of the string.
     * This method is used in the Rabin-Karp algorithm for string matching.
     * 
     * @param str The input string for which the hash value is to be calculated.
     * @return The calculated hash value.
     */
    private static long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (long) (hash + str.charAt(i)*Math.pow(PRIME,i));
        }
        return hash;
    }

    /**
     * Updates the hash value when a character is removed and a new character is added.
     * This is used in the Rabin-Karp algorithm to efficiently compute the hash of the
     * next substring without recalculating the entire hash from scratch.
     * 
     * The formula used is:
     * newHash = (previousHash - oldChar) / PRIME + newChar * PRIME^(patternLength - 1)
     * where oldChar is the character being removed, newChar is the character being added,
     * and patternLength is the length of the pattern being searched for
     * 
     * @param previousHash The hash value of the previous substring.
     * @param oldChar The character that is being removed from the substring.
     * @param newChar The character that is being added to the substring.
     * @param patternLength The length of the pattern being searched for.
     * @return The updated hash value.
     */
    private static long updateHash(long previousHash, char oldChar, char newChar, int patternLength) {
        long newHash = (previousHash-oldChar)/PRIME;
        newHash = (long) (newHash + newChar*Math.pow(PRIME, patternLength-1));
        return newHash;
    }

    /**
     * Searches for a pattern in a given text using the Rabin-Karp algorithm.
     * This algorithm uses a rolling hash technique to efficiently find the pattern
     * in the text. It calculates the hash of the pattern and compares it with the
     * hash of substrings of the text. If the hashes match, it performs a direct
     * comparison to confirm the match.
     * 
     * The algorithm works as follows:
     * 1. Calculate the hash of the pattern.
     * 2. Calculate the hash of the first window of text.
     * 3. Slide the window over the text one character at a time.
     * 4. Update the hash for the new window.
     * 5. If the hashes match, confirm by checking the actual substring.
     * 
     * @param text The text in which to search for the pattern.
     * @param pattern The pattern to search for in the text.
     * @return The starting index of the first occurrence of the pattern in the text,
     *         or -1 if the pattern is not found.
     */
    private static int search(String text, String pattern) {
        int patternLength = pattern.length();
        long patternHash = calculateHash(pattern);

        long textHash = calculateHash(text.substring(0, patternLength));
        for(int i = 0; i < text.length(); i++) {
            if (textHash == patternHash) {
                if (text.substring(i, i + patternLength).equals(pattern)) {
                    return i;
                }
            }
            if(i<text.length()-patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
            }
        }
        return -1;
    }
}
