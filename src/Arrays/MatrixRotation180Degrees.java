package Arrays;

//Idea is to first swap the columns followed by rows
public class MatrixRotation180Degrees {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {4,5,6,8},
                {9,10,11,12},
                {13,14,15,16}};

        //Swap the columns
        int left = 0, right = arr[0].length-1;
        while(left<right) {
            for(int row=0;row<arr.length;row++) {
                int temp=arr[row][left];
                arr[row][left]=arr[row][right];
                arr[row][right]=temp;
            }
            left++;
            right--;
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
