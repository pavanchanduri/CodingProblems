package Strings;

public class MinCharactersFrontForPalindrome {

    public static void main(String[] args) {
        String input = "aacecaaa";
        String reverse = new StringBuilder(input).reverse().toString(); //baaba

        for(int i = 1; i <= reverse.length(); i++){
            String newStr;
            newStr = reverse.substring(0,i)+input;
            if(isPalindrome(newStr)){
                System.out.println("Minimum Characters to be added is: "+i);
                System.exit(0);
            }
        }
    }

    private static boolean isPalindrome(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return true;
        } else {
            String reverse = new StringBuilder(str).reverse().toString();
            return str.equals(reverse);
        }
    }
}
