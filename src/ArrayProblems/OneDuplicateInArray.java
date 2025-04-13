package ArrayProblems;

/**
 LeetCode 287 - https://leetcode.com/problems/find-the-duplicate-number/
 Idea is to convert the given array in to a linked list with the element pointing to arr[element] as the next
 We then detect a loop using Floyd's Cycle Detection Algorithm
 For e.g., if the given array is [2,6,4,1,3,1,5] and it translates to the below
 2 -> 4 -> 3 -> 1 -> 6 -> 5
                |_________|
 */
public class OneDuplicateInArray {

    public static void main(String[] args) {
        //int[] arr = {2,5,9,6,9,3,8,9,7,1};
        int[] arr = {2,6,4,1,3,1,5};


        int slow = 0;
        int fast = 0;

        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while(slow!=fast);

        //Leave the slow pointer at the meeting point and re-start fast pointer from 0
        //Move both pointers one node at a time
        fast = 0;
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        System.out.println("Repeated number is: "+slow);
    }
}
