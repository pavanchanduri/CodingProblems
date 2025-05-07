package Strings;


public class StringArrange {
    public static void main(String[] args) {
        String str = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        char[] charArray = new char[str.length()];
        int i =0;
        while(i<str.length()) {
            charArray[indices[i]] = str.charAt(i);
            i++;
        }
        System.out.println(new String(charArray));
    }
}
