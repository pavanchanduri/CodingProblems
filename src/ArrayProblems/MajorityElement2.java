package ArrayProblems;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,3,3,2,2,2,2,2};
        System.out.println(majorityElement(nums));
    }

    /**
     * Given an integer array of size n, find all elements that appear more than n/3 times.
     * 
     * The algorithm works as follows:
     * 1. Use two counters and two potential majority elements.
     * 2. Traverse the array and update the counters based on the current number.
     * 3. If a counter reaches zero, update the corresponding majority element.
     * 4. After the first pass, verify the counts of the two potential majority elements
     *    to ensure they appear more than n/3 times.    
     * 
     * @param nums the input array of integers
     * @return a list of integers that appear more than n/3 times
     */
    public static List<Integer> majorityElement(int[] nums) {
        int counter1 = 0, counter2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (counter1 == 0 && num != element2) {
                counter1 = 1;
                element1 = num;
            } else if (counter2 == 0 && num != element1) {
                counter2 = 1;
                element2 = num;
            } else if(num == element1) {
                counter1++;
            } else if(num == element2) {
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }

        counter1 = 0;
        counter2 = 0;
        int minCount = (nums.length/3)+1;
        for (int num : nums) {
            if(element1 == num) {
                counter1++;
            } else if(element2 == num) {
                counter2++;
            }
        }

        if(counter1 >= minCount) {
            result.add(element1);
        }
        if(counter2 >= minCount) {
            result.add(element2);
        }
        return result;
    }
}
