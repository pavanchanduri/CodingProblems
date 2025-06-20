package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class CommonElementsIn3SortedArrays {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 10, 20, 80, 40, 80));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 20, 80, 80, 100));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 4, 15, 20, 30, 70, 80, 80, 120));

        List<Integer> resultList = commonElements(list1, list2, list3);
        System.out.println(resultList);
    }

    /**
     * This method finds common elements in three sorted arrays.
     * It uses a three-pointer technique to traverse through the arrays.
     * 
     * The algorithm works as follows:
     * 1. Initialize three pointers for each of the three lists.
     * 2. Compare the elements at these pointers.
     * 3. If the elements are equal, add the element to the result list and
     *    move all three pointers forward.
     * 4. If the elements are not equal, move the pointer of the list with the smallest element forward.
     *
     * @param list1 First sorted list of integers
     * @param list2 Second sorted list of integers
     * @param list3 Third sorted list of integers
     * @return A list containing common elements in all three lists
     */
    public static List<Integer> commonElements(List<Integer> list1, List<Integer> list2,
                                               List<Integer> list3) {
        int i=0,j=0,k=0;
        List<Integer> resultList = new ArrayList<>();

        while(i< list1.size() && j< list2.size() && k< list3.size()) {

            if(Objects.equals(list1.get(i), list2.get(j)) && Objects.equals(list2.get(j), list3.get(k))) {
                if(!resultList.contains(list1.get(i))) {
                    resultList.add(list1.get(i));
                }
                i++;j++;k++;
            } else if(list1.get(i) < list2.get(j)) {
                i++;
            } else if(list2.get(j) < list3.get(k)) {
                j++;
            } else {
                k++;
            }
        }
        return resultList;
    }
}
