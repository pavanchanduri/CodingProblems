package Matrix;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},
                        {1,1,0,1},
                        {1,1,0,0},
                        {0,1,1,1}};
        List<String> result = new ArrayList<>();
        ratInMaze(maze, 0, 0, "", result);
        System.out.println(result);
    }

    private static void ratInMaze(int[][] mat, int row, int col, String path, List<String> result) {
        int n = mat.length;

        //base cases -1 is when the cell has been visited
        if(row < 0 || row >= n || col < 0 || col >= n || mat[row][col] == 0 || mat[row][col] == -1) {
            return ;
        }

        if(row == n-1 && col == n-1) {
            result.add(path);
            return;
        }
        mat[row][col] = -1; //Visited flag
        ratInMaze(mat, row+1, col, path+"D", result);
        ratInMaze(mat, row-1, col, path+"U", result);
        ratInMaze(mat, row, col+1, path+"R", result);
        ratInMaze(mat, row, col-1, path+"L", result);
        mat[row][col] = 1; //Backtracking -- Make it unvisited
    }
}
