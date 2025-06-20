package ArrayProblems;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,5,6,9,15};
        int[] arr2 = {1,3,5,7,10,12,13,14};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    /**
     * This method finds the median of two sorted arrays.
     * It uses binary search to find the correct partition point
     * in the smaller array, ensuring that the left side contains
     * all elements less than or equal to the right side.
     * 
     * The algorithm works as follows:
     * 1. Ensure that nums1 is the smaller array.
     * 2. Calculate the total length of both arrays.
     * 3. Use binary search on the smaller array to find the partition point.
     * 4. Calculate the left and right elements around the partition.
     * 5. Check if the partition is valid (i.e., all left elements are
     *   less than or equal to the right elements).
     * 6. If valid, calculate the median based on the total length
     *   (even or odd).
     * 7. If not valid, adjust the binary search range accordingly.
     *
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return The median of the two sorted arrays
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = n1+n2;
        int left = (n1+n2+1)/2;
        int low=0, high=n1;

        while(low <= high) {
            int mid1 = (low + high)/2;
            int mid2 = left-mid1;

            int l1= (mid1>0) ? nums1[mid1-1] : Integer.MIN_VALUE;
            int l2= (mid2>0) ? nums2[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1<n1) ? nums1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2<n2) ? nums2[mid2] : Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1) {
                if(n%2==0) {
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                } else {
                    return Math.max(l1,l2);
                }
            } else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0.0;
    }

}
