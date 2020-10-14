import com.sun.tools.javac.util.Pair;

import java.util.*;

public class PairOfIntWithDIffK {
    public static void main(String[] args) {
       /* Pair<Integer, Integer> pair = findPairs(new int[]{1,4,7,3,2}, 3);
        if(pair == null){
            System.out.println("Null");
        }
        else {
            System.out.println(pair.fst + " "+ pair.snd);
        }*/
        //findAllPairs(new int[]{1,4,7,3,2}, 3).forEach( p -> System.out.println(p.fst + " " + p.snd ));
        findPairsNoExtraSpace(new int[]{1,4,7,3,5}, 3).forEach(System.out::println);
    }
    public static Pair<Integer, Integer> findPairs(int[] arr, int k ){
        if(arr == null || arr.length < 2)
            return null;
        HashSet<Integer> set= new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            int c1 = arr[i] - k;
            int c2 = arr[i] + k;
            if(set.contains(c1))
                return new Pair( c1,arr[i]);
            if(set.contains(c2))
                return new Pair(arr[i], c2);
            set.add(arr[i]);
        }
        return null;
    }
    public static List<Pair<Integer, Integer>> findAllPairs(int[] arr, int k ){
        if(arr == null || arr.length < 2)
            return null;
        HashMap<Integer, Boolean> map= new HashMap<Integer, Boolean>();
        for(int i : arr){
            map.put(i, Boolean.TRUE);
        }
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int c1 = arr[i] - k;
            int c2 = arr[i] + k;
            if(map.containsKey(c1) && map.get(c1))
                list.add(new Pair(c1,arr[i]));
            if(map.containsKey(c2) &&map.get(c2))
                list.add(new Pair(arr[i], c2));
            map.put(arr[i], Boolean.FALSE);
        }
        return list;
    }
    public static List<Pair<Integer, Integer>> findPairsNoExtraSpace(int[] arr, int k ){
        if(arr == null || arr.length < 2)
            return null;
        Arrays.sort(arr);
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        int i = 0;
        int j = 1;
        while(i < j && j < arr.length){
            if((arr[j] - arr[i]) > k){
                i++;
            }
            else if((arr[j] - arr[i]) < k ){
                j++;
            }
            else {
                list.add(new Pair(arr[i], arr[j]));
                i++;
                j++;
            }
        }

        return list;
    }

}
