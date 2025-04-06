package Arrays;

import java.util.*;

public class TripletsUsingMap {

    public static void main(String[] args) {
        int[] arr = {7,-6,3,8,-1,8,-11};
        int target = 0;
        List<List<Integer>> res = triplets(arr, target, arr.length);
        for (List<Integer> triplet : res) {
            triplet.forEach(num -> System.out.print(num + " "));
            System.out.println();
        }

    }

    public static List<List<Integer>> triplets(int[] arr, int target, int n) {

        Map<Integer, List<int[]>> mp = new HashMap<>();
        Set<List<Integer>> result = new HashSet<>();

        // Store all pairs for every possible pairs sum
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //mp.computeIfAbsent(arr[i] + arr[j], k -> new ArrayList<>()).add(new int[]{i, j});
                if(mp.containsKey(arr[i]+arr[j])) {
                    mp.get(arr[i]+arr[j]).add(new int[]{i, j});
                } else {
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i, j});
                    mp.put(arr[i]+arr[j], list);
                }
            }
        }

        for(int i=0;i<n;i++){
            int remain = target - arr[i];
            if(mp.containsKey(remain)){
                for(int[] p: mp.get(remain)){
                    if(p[0]!=i && p[1]!=i) {
                        List<Integer> curr = Arrays.asList(p[0], p[1], i);
                        Collections.sort(curr);
                        result.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
