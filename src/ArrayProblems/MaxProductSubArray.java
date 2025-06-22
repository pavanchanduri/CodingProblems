package ArrayProblems;

/**
1. Take two pointer approach and iterative over the array from both sides
2. If any product becomes zero, make the product 1 so that the new product gets computed
   from the next element onwards.
3. Pick the maximum product among existing product and max of leftProduct and rightProduct
 */
public class MaxProductSubArray {

    public static void main(String[] args) {

        int[] arr = {2,3,-2,-5,6,-1,4};
        int n = arr.length;
        System.out.println(maxProduct(arr, n));
    }

    /**
     * This method calculates the maximum product of a subarray in the given array.
     * It uses a two-pointer approach to compute the product from both ends of the array.
     * If any product becomes zero, it resets the product to 1 for further calculations.
     * 
     * The algorithm works as follows:
     * 1. Initialize two variables to keep track of the product from the left and right
     *   ends of the array.
     * 2. Iterate through the array from both ends simultaneously.
     * 3. For each element, multiply it with the current product from the left and
     *  right ends.
     * 4. If the product becomes zero, reset it to 1 to avoid multiplying by zero in
     *    future calculations.
     * 5. Keep track of the maximum product found during the iteration.
     * 6. Return the maximum product found.
     *
     * @param arr the input array
     * @param n   the length of the array
     * @return the maximum product of any subarray
     */
    private static int maxProduct(int[] arr, int n) {
        int leftProduct = 1;
        int rightProduct = 1;

        int maxProd = arr[0];

        for (int i = 0; i < n; i++) {

            leftProduct = leftProduct==0 ? 1 : leftProduct*arr[i]; // Reset if product becomes zero
            rightProduct = rightProduct==0 ? 1 : rightProduct*arr[n-1-i]; // Reset if product becomes zero
            maxProd = Math.max(maxProd, Math.max(leftProduct, rightProduct));
        }
        return maxProd;
    }
}
