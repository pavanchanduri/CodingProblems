package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {11, 3, 7, 9, 14, 2, 15, 16, 1, 15, 2};
        int target = 17;
        Set<String> set = new HashSet<>();
        HashMap<Integer, Integer> map = new LinkedHashMap<>();

        //Iterate in the map to find the elements
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i])) {
                set.add(map.get(target-arr[i])+" "+i);
            } else {
                map.put(arr[i], i);
            }
        }
        System.out.println(set);
    }
}
