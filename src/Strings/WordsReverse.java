package Strings;

public class WordsReverse {
    public static void main(String[] args) {
        String s1 = "This is a string";
        String[] str = s1.split(" ");
        StringBuilder resultStr = new StringBuilder();

        for(int i = 0; i < str.length; i++){
            resultStr.append(" ").append(new StringBuilder(str[i]).reverse());
        }
        System.out.println(resultStr.substring(1, resultStr.length()));
    }
}
