package Arrays;

public class MaxMin {

    public static void main(String[] args) {

        // Find Max, Second Max, Min and Second Min elements in an Array
        int[] arr = {5,7,9,18,20,-9,12,-3,6,13,-10};

        int min = Integer.MAX_VALUE;
        int secondMin =Integer.MAX_VALUE;

        int max = Integer.MIN_VALUE;
        int secondMax =Integer.MIN_VALUE;

        for(int j:arr) {
            if(j > max) {
                secondMax = max;
                max = j;
            } else if(j > secondMax) {
                secondMax = j;
            }
        }

        for (int j : arr) {
            if (j < min) {
                secondMin = min;
                min = j;
            } else if (j < secondMin) {
                secondMin = j;
            }
        }

        System.out.println(max+" "+secondMax);
        System.out.println(min+" "+secondMin);
    }
}
