package Strings;

import java.util.ArrayList;
import java.util.List;

public class LargestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        String s = "pwwkew";

        int maxLength = 0;
        int length;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(list.contains(ch)){
                int index = list.indexOf(ch);
                for(int j = 0; j <= index; j++){
                    list.remove(list.getFirst());
                }
            }
            list.add(ch);
            length = list.size();
            maxLength = Math.max(maxLength, length);
        }
        System.out.println(maxLength);
    }
}
