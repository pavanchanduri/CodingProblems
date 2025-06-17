package Strings;

public class StringRotationCompare {
    /**
     * This class checks if two strings are rotations of each other.
     * It does this by rotating the first string by k positions and checking if it matches the
     * second string.
     * 
     * The algorithm works as follows:
     * 1. Iterate through the first string, rotating it by 1 to n positions
     * 2. For each rotation, check if it matches the second string.
     * 3. If a match is found, print that the strings are rotations of each other.
     * 4. If no match is found after all rotations, print that the strings are not rotations of each other.
     * 
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "defgabc";

        boolean flag = false;
        for(int i = 1; i <= str1.length(); i++) {
            if(rotateString(str1, i).equals(str2)) {
                flag = true;
            }
        }
        if(flag) {
            System.out.println("Strings are rotations of each other");
        } else {
            System.out.println("Strings are not rotations of each other");
        }
    }

    /**
     * Rotates a string by k positions to the right.
     * The rotation is done in-place by reversing parts of the string.
     * 
     * @param s The input string to be rotated.
     * @param k The number of positions to rotate the string.
     * @return The rotated string.
     */
    private static String rotateString(String s, int k) {
        char[] charArray = s.toCharArray();

        k=k%charArray.length;
        reverseChars(charArray,0,charArray.length-k-1);
        reverseChars(charArray,charArray.length-k,charArray.length-1);
        reverseChars(charArray,0,charArray.length-1);

        return new String(charArray);
    }

    private static void reverseChars(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
}
