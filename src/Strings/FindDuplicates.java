package Strings;

public class FindDuplicates {

    public static void main(String[] args) {
        String str = "bcbaabcedffffeeecdfghijklmnopqrstuvwxyz";
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for(int i=0;i<26;i++) {
            if(count[i]>1) {
                System.out.print((char)(i+'a')+" ");
            }
        }
    }
}
