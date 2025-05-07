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

    private static long calculateHash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (long) (hash + str.charAt(i)*Math.pow(PRIME,i));
        }
        return hash;
    }

    private static long updateHash(long previousHash, char oldChar, char newChar, int patternLength) {
        long newHash = (previousHash-oldChar)/PRIME;
        newHash = (long) (newHash + newChar*Math.pow(PRIME, patternLength-1));
        return newHash;
    }

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
