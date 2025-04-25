package Matrix;

/**
1. Transpose the matrix
2. Swap the rows
 */
public class MatrixRotation270Degrees {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};

        //Transpose the matrix
        for(int i = 0; i < arr.length; i++) {
            for(int j = i+1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //Swap the rows
        int top = 0, bottom = arr.length-1;
        while(top<bottom) {
            for(int col=0;col<arr.length;col++) {
                int temp=arr[top][col];
                arr[top][col]=arr[bottom][col];
                arr[bottom][col]=temp;
            }
            top++;
            bottom--;
        }


        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
