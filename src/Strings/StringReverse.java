package Strings;

public class StringReverse {
    public static void main(String[] args) {
        String s1 = "This is a string";

        char[] words = s1.toCharArray();
        int left = 0, right = words.length - 1;
        while (left < right) {
            char temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        String s2 = new String(words);
        System.out.println(s2);
    }
}
