package Arrays;

import java.util.*;

/**
1. Find out all the possible pairs along with their sum and store it in a map
2. Iterate over the map and find the pairs that match the remaining sum i.e., target-arr[i]-arr[j]
3. Validate and store the indexes that are not matching i.e., if (p[0] != i && p[1] != i && p[0] != j && p[1] != j)
 */
public class Quadruplets {

    public static List<List<Integer>> fourSum(int[] arr, int target) {
        int n = arr.length;
        Map<Integer, List<int[]>> mp = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();

        // Store all pairs for every possible pairs sum
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(mp.containsKey(arr[i]+arr[j])) {
                    mp.get(arr[i]+arr[j]).add(new int[]{i, j});
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    mp.put(arr[i]+arr[j], list);
                }
                //mp.computeIfAbsent(arr[i] + arr[j], k -> new ArrayList<>()).add(new int[]{i, j});
            }
        }

        // Pick the first two elements
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                // Find pairs with the remaining sum
                int rem = target - arr[i] - arr[j];
                if (mp.containsKey(rem)) {
                    for (int[] p : mp.get(rem)) {

                        // Ensure no two indexes are the same in a quadruple
                        // And all indexes are in sorted order
                        if (p[0] != i && p[1] != i && p[0] != j && p[1] != j) {
                            List<Integer> curr = Arrays.asList(p[0], p[1], i, j);
                            Collections.sort(curr);
                            result.add(curr);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = fourSum(arr, target);
        for (List<Integer> quad : res) {
            quad.forEach(num -> System.out.print(arr[num] + " "));
            System.out.println();
        }
    }
}
