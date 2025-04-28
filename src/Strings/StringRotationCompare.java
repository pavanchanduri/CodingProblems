package Strings;

public class StringRotationCompare {
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
