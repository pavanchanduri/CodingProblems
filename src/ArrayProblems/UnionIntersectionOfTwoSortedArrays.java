package ArrayProblems;

public class UnionIntersectionOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,5,7,8,9,10};
        int[] arr2 = {0,1,2,3,4,5,6,8,9,10};

        union(arr1,arr2);
        System.out.println();
        intersection(arr1,arr2);
    }

    private static void union(int[] arr1, int[] arr2){

        int i=0,j=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                System.out.print(arr1[i]+" ");
                i++;
            } else if(arr1[i]>arr2[j]){
                System.out.print(arr2[j]+" ");
                j++;
            } else {
                System.out.print(arr1[i]+" "); //If equal, print from either of the array and move both pointers
                i++;
                j++;
            }
        }

        while(i<arr1.length){
            System.out.print(arr1[i++]+" ");
        }
        while(j<arr2.length){
            System.out.print(arr2[j++]+" ");
        }
    }

    private static void intersection(int[] arr1, int[] arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                i++;
            } else if(arr1[i]>arr2[j]){
                j++;
            } else {
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
        }
    }
}
