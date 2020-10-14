package arrays;

import java.util.*;
import java.util.stream.IntStream;

public class SumToZero {

    public static boolean isThreeSum(int[] inpArr, int val) {
        if (inpArr == null || inpArr.length < 3)
            return false;
        for (int i = 0; i < inpArr.length - 3; i++) {
            int remSum = val - inpArr[i];
            HashSet<Integer> diff = new HashSet<>();
            for (int j = i + 1; j < inpArr.length; j++) {
                if (diff.contains(remSum - inpArr[j]))
                    return true;
                diff.add(inpArr[j]);
            }
        }
        return false;
    }

    private static void addSortedListToResults(Set<List<Integer>> results, int e, int e1, int e2) {
        LinkedList<Integer> elems = new LinkedList<>();
        elems.add(e);
        elems.add(e1);
        elems.add(e2);
        Collections.sort(elems);
        results.add(elems);
    }

    private static void twoSum(int[] inpArr, int remSum, Set<List<Integer>> results, int i) {

        HashSet<Integer> diff = new HashSet<>();
        for (int j = i + 1; j < inpArr.length; j++) {
            int reqSum = remSum - inpArr[j];
            if (diff.contains(reqSum)) {
                addSortedListToResults(results, inpArr[i], reqSum, inpArr[j]);
                diff.remove(reqSum);
            }
            else {
                diff.add(inpArr[j]);
            }

        }
    }

    public static List<List<Integer>> threeSum(int[] inpArr, int val) {
        Set<List<Integer>> results = new HashSet<>();
        if (inpArr == null || inpArr.length < 3)
            return new ArrayList<>();

        for (int i = 0; i < inpArr.length - 3; i++) {
            twoSum(inpArr, val - inpArr[i], results, i);
        }

        return new ArrayList<>(results);
    }




    public static void testThreeSumToZero() {
        int sum = 0;
        int[] inpArr = {0, 0, 0, -1, -1, -1,1,1,1,2,2,2};
        System.out.println("Three elements with sum = 0 exists? :"+ isThreeSum(inpArr, sum));

        List<List<Integer>> result = threeSum(inpArr, sum);
        for (List<Integer> l : result) {
            System.out.print("{ ");
            for (int i : l) {
                System.out.print(i);
                System.out.print(", ");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        //testThreeSumToZero();
        IntStream stream = "12345_abcdefg".chars();
        //System.out.print(strea);
        stream.forEach(p -> System.out.println(p));

    }
}
