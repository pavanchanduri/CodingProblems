package Matrix;

import java.util.HashMap;
import java.util.Map;

public class CommonElementsInAllRows {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 1, 4, 8},
                       {3, 7, 8, 5, 1},
                       {8, 7, 7, 3, 1},
                       {8, 1, 2, 7, 9},};

        Map<Integer, Integer> map = new HashMap<>();

        //Place the first row elements in the map
        for (int j = 0; j < mat[0].length; j++)
            map.put(mat[0][j],1);

        for(int i = 1; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                // If element is present in the map and
                // is not duplicated in current row.
                if (map.containsKey(mat[i][j]) && map.get(mat[i][j]) == i)
                {
                    // map.get(mat[i][j]) == i - to ensure we dont consider duplicates
                    // we increment count of the element in the map by 1
                    map.put(mat[i][j], i + 1);
                }
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.print(entry.getKey()+" ");
            }
        }
    }
}
