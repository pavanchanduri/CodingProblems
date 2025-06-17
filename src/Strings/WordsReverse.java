package Strings;

public class WordsReverse {
    /**
     * This class reverses each word in a given string while maintaining the original order of the words.
     * It splits the string into words, reverses each word, and then constructs a new string with the reversed words.
     * 
     * The algorithm works as follows:
     * 1. Split the input string into an array of words using space as a delimiter.
     * 2. For each word in the array, reverse it using StringBuilder.
     * 3. Append each reversed word to a StringBuilder to construct the final result.
     * 4. Print the final result after removing any leading space.
     */
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
