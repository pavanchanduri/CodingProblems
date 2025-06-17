package Strings;

/**
 * This class demonstrates how to rearrange a string based on given indices.
 * 
 * The algorithm works as follows:
 * 1. Create a character array of the same length as the input string.
 * 2. Iterate through the input string and for each character, place it in the
 *    character array at the index specified by the corresponding value in the indices array.
 * 3. Finally, convert the character array back to a string and print it.
 */
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
