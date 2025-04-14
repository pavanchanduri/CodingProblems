package ArrayProblems;

import java.util.*;

public class CommonElementsIn3SortedArrays {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5, 10, 20, 80, 40, 80));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(6, 7, 20, 80, 80, 100));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(3, 4, 15, 20, 30, 70, 80, 80, 120));

        List<Integer> resultList = commonElements(list1, list2, list3);
        System.out.println(resultList);
    }

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

    public List<Integer> commonElements_Old(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        Set<Integer> temp = new LinkedHashSet<>();
        Set<Integer> resultSet = new LinkedHashSet<>();

        int i=0,j=0;

        while(i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i)<arr2.get(j)) {
                i++;
            } else if(arr1.get(i)>arr2.get(j)) {
                j++;
            } else {
                temp.add(arr1.get(i));
                i++;
                j++;
            }
        }
        List<Integer> tempList = new ArrayList<>(temp);

        i=0;j=0;

        while(i<tempList.size() && j<arr3.size()) {
            if(tempList.get(i)<arr3.get(j)) {
                i++;
            } else if(tempList.get(i)>arr3.get(j)) {
                j++;
            } else {
                resultSet.add(tempList.get(i));
                i++;
                j++;
            }
        }
        return new ArrayList<>(resultSet);
    }
}
