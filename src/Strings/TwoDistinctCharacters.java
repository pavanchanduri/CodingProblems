package Strings;

import java.util.Scanner;

public class TwoDistinctCharacters {

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
