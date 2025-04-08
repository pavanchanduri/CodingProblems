package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 1. Initialize the start index as i and find the lastIndex of the same element and store as endIndex
 2. Start a loop with startIndex+1 i.e., next element  and find the lastIndex of the same
 3. If the last index is more than the endIndex captured in step 1, change the endIndex
 4. Add the length of the sub string i.e., endIndex-startIndex+1 as one partition
 5. Update 'i' to endIndex+1 for the outer loop
 */
public class PartitionLabels {

    public static void main(String[] args) {

        String str = "ababcbacadefegdehijhklij";
        List<Integer> partitions = new ArrayList<>();

        for(int i = 0; i < str.length();){

            //First Index and Last Index of the first character
            int startIndex = i;
            int endIndex = str.lastIndexOf(str.charAt(i));

            for(int j = startIndex+1; j <= endIndex-1; j++){
                int lastIndexOfNextCharacter = str.lastIndexOf(str.charAt(j));

                if(lastIndexOfNextCharacter > endIndex) {
                   endIndex = lastIndexOfNextCharacter;
                }
            }
            partitions.add(endIndex-startIndex+1);
            i = endIndex+1;
        }
        partitions.forEach(System.out::println);
    }
}
