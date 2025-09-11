package Matrix;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        getTranspose(matrix);
        for(int row=0;row<matrix.length;row++) {
            for(int col=0;col<matrix[0].length;col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Transpose the given matrix in place
     * The algorithm works by swapping elements across the main diagonal.
     * It iterates through the upper triangle of the matrix (excluding the diagonal)
     * and swaps each element with its corresponding element in the lower triangle.
     * This approach ensures that each pair of elements is swapped only once,
     * resulting in an efficient in-place transposition.
     * 
     * @param matrix The square matrix to be transposed
     */
    private static void getTranspose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
