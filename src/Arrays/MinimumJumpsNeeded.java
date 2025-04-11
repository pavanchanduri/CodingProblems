package Arrays;

/**
 1. Iterate through the array and find a maxIndex and for each jump find an endIndex
 2. Until 'i' reached endIndex, compute the maxIndex, which would correspond to the next jump
 */
public class MinimumJumpsNeeded {

    public static void main(String[] args) {
        int maxIndex, endIndex = 0;
        int jumps = 0;
        int[] arr = {1,3,5,8,4,2,6,3};
        maxIndex = 0;

        for(int i = 0; i < arr.length; i++){
            maxIndex = Math.max(maxIndex, i+arr[i]);

            if(endIndex == i) {
                endIndex = maxIndex;
                jumps++;
            }

            if(endIndex>=arr.length-1){
                break;
            }
        }
        if(endIndex < arr.length-1){
            System.out.println("No Jumps");
        } else {
            System.out.println("Jumps: "+jumps);
        }

    }
}
