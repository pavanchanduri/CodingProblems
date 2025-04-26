package Matrix;

public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},
                          {3,4,5,2},
                          {1,3,1,5}};
        int[][] result = setZeros(matrix, matrix.length, matrix[0].length);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] setZeros(int[][] matrix, int n, int m) {
        //int col[m] = {0}; -> matrix[0][..]
        //int row[n] = {0}; -> matrix[..][0]

        int column0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if(j!=0) {
                        matrix[0][j] = 0;
                    } else {
                        column0=0;
                    }
                }
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(matrix[i][j]!=0) {
                    if(matrix[0][j]==0 || matrix[i][0]==0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        //Mark the column entries as zero
        if(matrix[0][0]==0) {
            for(int j=1;j<m;j++) {
                matrix[0][j] = 0;
            }
        }
        //Mark the row entries as zer0
        if(column0==0) {
            for(int i=1;i<n;i++) {
                matrix[i][0] = 0;
            }
        }
        return matrix;
    }
}
