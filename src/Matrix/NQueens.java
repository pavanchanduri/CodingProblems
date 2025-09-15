package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
    }

    /**
     * This method solves the N-Queens problem and returns all distinct solutions for placing N queens on an N x N chessboard
     * such that no two queens threaten each other. 
     * The algorithm uses backtracking to explore all possible placements of queens row by row. 
     * When a valid configuration is found (i.e., all queens are placed without conflicts), it is added to the result list.
     * The board is represented as a list of strings, where 'Q' indicates a queen and '.' indicates an empty space.
     * The algorithm works as follows:
     * 1. Initialize an empty board of size N x N.
     * 2. Use a recursive backtracking function to attempt to place queens row by row.
     * 3. For each row, iterate through each column and check if placing a queen there is safe (i.e., no other queens can attack it).
     * 4. If it is safe, place the queen and recursively attempt to place queens in the next row.
     * 5. If a valid configuration is found (i.e., all queens are placed), add the current board configuration to the result list.
     * 6. Backtrack by removing the queen and trying the next column in the current row.
     * 7. Continue this process until all possible configurations have been explored.
     * 
     * @param n The size of the chessboard and the number of queens to place.
     * @return A list of all distinct solutions, where each solution is represented as a list of strings.
     */
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0, result);
        return result;
    }

    /**
     * This is a recursive backtracking function that attempts to place queens on the board row by row.
     * It checks for safe placements and constructs valid board configurations when all queens are placed.  
     * @param board the current state of the chessboard
     * @param row the current row to attempt to place a queen
     * @param result the list to store all valid board configurations
     */
    private static void backtrack(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, result);
                board[row][col] = '.';
            }
        }
    }

    /**
     * This method checks if placing a queen at the given row and column is safe.
     * It checks the column and both diagonals for any existing queens.
     *
     * @param board the current state of the chessboard
     * @param row the current row to check
     * @param col the current column to check
     * @return true if it is safe to place a queen at (row, col), false otherwise
     */
    private static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    /**
     * This method constructs a list of strings representing the current state of the chessboard.
     * Each string corresponds to a row on the board, with 'Q' for queens and '.' for empty spaces.
     *
     * @param board the current state of the chessboard
     * @return a list of strings representing the current board configuration
     */
    private static List<String> constructBoard(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
           solution.add(new String(row));
        }
        return solution;
    }
}
