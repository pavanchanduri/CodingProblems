package ArrayProblems;

import java.util.HashSet;
import java.util.Set;

/**
 1. Push all elements in to Set
 2. Iterate over all elements in the array and if there exists an element for which there is no previous value
    i.e., value-1 => Can be the start of our consecutive subsequence
 3. Loop through the Set and check if there exists value+1 and increment the counter and remove the currentValue to avoid
    re-computation
 */
public class LongestConsecutiveSubSequence {

    public static void main(String[] args) {
        int[] arr = {2, 6, 1, 9, 4, 5, 3};
        int result = 0;

        Set<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }

        for(int value: arr) {
            if(set.contains(value) && !set.contains(value-1)) {
                int currValue = value;
                int count = 0;
                while(set.contains(currValue)) {
                    set.remove(currValue);
                    count++;
                    currValue++;
                }
                result = Math.max(result, count);
            }
        }
        System.out.println(result);
    }
}
