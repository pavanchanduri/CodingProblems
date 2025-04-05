package Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {5,7,4,7,4,4,5,4,4,7,4,4};

        int candidate = arr[0];
        int count = 1;

        for(int i=1;i<arr.length;i++) {
            if(arr[i]==candidate) {
                count++;
            }else {
                count--;
            }

            if(count==0) {
                candidate = arr[i];
                count = 1;
            }
        }

        count = 0;
        for (int i : arr) {
            if (i == candidate) {
                count++;
            }
        }

        if(count > arr.length/2) {
            System.out.println("Majority element found: "+candidate);
        }
    }
}
