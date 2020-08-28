package arrays;

import java.util.*;

public class SumToZero {

    public static boolean isThreeSum(int[] inpArr, int val) {
        if (inpArr == null || inpArr.length < 3)
            return false;
        for (int i = 0; i < inpArr.length; i++) {
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

    public static List<List<Integer>> threeSum(int[] inpArr, int val) {
        Set<List<Integer>> results = new HashSet<>();
        if (inpArr == null || inpArr.length < 3)
            return new ArrayList<>();

        for (int i = 0; i < inpArr.length; i++) {
            int remSum = val - inpArr[i];
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

        return new ArrayList<>(results);
    }


    public static void testThreeSumToZero() {
        int sum = 0;
        int[] inpArr = {-1, 0, 1, 2, -1, -4};
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
        testThreeSumToZero();
    }
}
