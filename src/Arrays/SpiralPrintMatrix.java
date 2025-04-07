package Arrays;

/**
1. Print the first row and increment rMin
2. Print the last column and decrement cMax
3. Print the last row and decrement rMax
4. Print the first column and increment cMin
5. Print the above steps till all elements in the Matrix are printed i.e., count equals M*N
 **/
public class SpiralPrintMatrix {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {4,5,6,8,9},
                {9,10,11,12,13},
                {13,14,15,16,19},
                {20,21,22,23,24}
        };

        int count = 0;
        int rMin = 0, rMax = arr.length-1, cMin = 0, cMax = arr[0].length-1;
        int n=arr.length;
        int m=arr[0].length;

        while(count<n*m) {
            for(int col=cMin;col<=cMax && count<n*m;col++) {
                System.out.print(arr[rMin][col]+" ");
                count++;
            }
            rMin++;
            for(int row=rMin;row<=rMax && count<n*m;row++) {
                System.out.print(arr[row][cMax]+" ");
                count++;
            }
            cMax--;
            for(int col=cMax;col>=cMin && count<n*m;col--) {
                System.out.print(arr[rMax][col]+" ");
                count++;
            }
            rMax--;
            for(int row=rMax;row>=rMin && count<n*m;row--) {
                System.out.print(arr[row][cMin]+" ");
                count++;
            }
            cMin++;
        }
    }
}
