package Arrays;

//90 degrees rotation -> Idea is to first transpose the matrix followed by swapping of the columns
public class MatrixRotation {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {4,5,6,8},
                {9,10,11,12},
                {13,14,15,16}};

        //rotate 90 degrees
        int[][] rotatedMatrix = rotate90Degrees(arr);
        printMatrix(rotatedMatrix);
        System.out.println();

        //Send the 90 degrees rotated matrix which rotates it by 90 degrees more -> 180 degrees
        int[][] rotated180Matrix = rotate90Degrees(rotatedMatrix);
        printMatrix(rotated180Matrix);
        System.out.println();

        //Send the 180 degrees rotated matrix which rotates it by 90 degrees more -> 270 degrees
        int[][] rotated270Matrix = rotate90Degrees(rotated180Matrix);
        printMatrix(rotated270Matrix);
        System.out.println();

        //Send the 270 degrees rotated matrix which rotates it by 90 degrees more -> 360 degrees = original matrix
        int[][] rotated360Matrix = rotate90Degrees(rotated270Matrix);
        printMatrix(rotated360Matrix);

    }

    private static int[][] rotate90Degrees(int[][] arr) {

        //Transpose the matrix
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr[0].length;j++) {
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }

        //Swap the columns
        int left = 0, right = arr[0].length-1;
        while(left<right) {
            for(int i=0;i<arr.length;i++) {
                int temp=arr[i][left];
                arr[i][left]=arr[i][right];
                arr[i][right]=temp;
            }
            left++;
            right--;
        }
        return arr;
    }

    private static void printMatrix(int[][] arr) {

        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
