package ArrayProblems;

/**
 1. Take 3 pointers Start, Middle and End with Start and Middle at zero index and end at the last index
 2. If the element at arr[middle] is zero, swap with start and increment middle and start
 3. If the element at arr[middle] is one, do nothing and move middle pointer
 4. If the element at arr[middle] is two, swap with end and increment end and don't increment middle as we are not sure
    of the element at middle pointer
 5. Repeat the loop till middle crosses end
 */
public class Partition012 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 0, 0, 1, 2, 0, 1, 2, 2, 1, 0, 2, 0, 1, 0};

        int start = 0, middle = 0, end = arr.length - 1;

        while (middle <= end) {

            if(arr[middle] == 0) {
                swap(arr, start, middle);
                start++;
                middle++;
            } else if(arr[middle] == 1) {
                middle++;
            } else {
                swap(arr, middle, end);
                end--;
            }
        }

        for(int i: arr) {
            System.out.print(i + " ");
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}