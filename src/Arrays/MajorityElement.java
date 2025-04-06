package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {5,7,4,7,4,4,5,4,4,7,4,4};

        //Using counter based approach
        System.out.println(majorityElementUsingCounter(arr));

        //Using Frequency Map
        System.out.println(majorityElementUsingFrequencyMap(arr));

    }

    private static int majorityElementUsingFrequencyMap(int[] nums) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if(entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private static int majorityElementUsingCounter(int[] nums) {

        int candidate = nums[0];
        int count = 1;

        for(int i=1;i<nums.length;i++) {
            if(nums[i]==candidate) {
                count++;
            }else {
                count--;
            }

            if(count==0) {
                candidate = nums[i];
                count = 1;
            }
        }

        count = 0;
        for (int i : nums) {
            if (i == candidate) {
                count++;
            }
        }

        if(count > nums.length/2) {
            return candidate;
        }
        return -1;
    }
}
