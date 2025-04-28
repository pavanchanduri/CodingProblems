package Strings;

public class StringPatternMatching {

    public static void main(String[] args) {
        String text = "AABAACAADAABAABAAB";
        String pattern = "AABA";

        for(int i=0; i<text.length(); i++){
            if(pattern.charAt(0) == text.charAt(i)) {
                if (((i + pattern.length()) <= text.length()) &&
                        pattern.equals(text.substring(i, i + pattern.length()))) {
                    System.out.println(i);
                }
            }
        }
    }
}
