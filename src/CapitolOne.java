
import java.util.*;
import java.util.stream.*;
public class CapitolOne {
    public static void main(String[] args) {
        System.out.println(moves(Arrays.asList(5,8,5,11,4,6)));
    }
    public static int moves(List<Integer> arr) {
        if(arr == null)
            return 0;
        long evenCount = arr.stream().filter(c -> c%2 == 0).count();
        long missedEvens = arr.stream().limit(evenCount).filter(c -> c%2 != 0).count();
        return (int)missedEvens;
    }
}
