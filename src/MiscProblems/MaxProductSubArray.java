package MiscProblems;

/*
1. Take two pointer approach and iterative over the array from both sides
2. If any product becomes zero, make the product 1 so that the new product gets computed
   from the next element onwards.
3. Pick the maximum product among existing product and max of leftProduct and rightProduct
 */
public class MaxProductSubArray {

    public static void main(String[] args) {

        int[] arr = {2,3,-2,-5,6,-1,4};
        int n = arr.length;
        int leftProduct = 1;
        int rightProduct = 1;

        int ans = arr[0];

        for (int i = 0; i < n; i++) {

            leftProduct = leftProduct == 0 ? 1 :leftProduct;
            rightProduct = rightProduct == 0 ? 1 :rightProduct;

            leftProduct *= arr[i];
            rightProduct *= arr[n-i-1];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }
        System.out.println(ans);
    }
}
