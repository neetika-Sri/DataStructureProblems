import java.util.Arrays;

public class SortedSquare {
    public static void main(String[] args) {
        Arrays.stream(sortArray(new int[]{-3, -2, -1, 1, 3, 90, 43, 55})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(sortArray(new int[]{-3, -2, -1})).forEach(System.out::print);
        System.out.println();
        Arrays.stream(sortArray(new int[]{1,2,3})).forEach(System.out::print);
    }
    public static long[] sortArray(int[] arr){
        // -5,-4,-3,0, 5,6,7,8
        int j = 0;
        while(j < arr.length && arr[j] < 0){
            j++;
        }
       int i = j-1;
       int k = -1;
       long[] sorted = new long[arr.length];
       while(i >= 0 && j < arr.length){
           long iSquare = (long)arr[i] * (long)arr[i];
           long jSquare = (long)arr[j] * (long)arr[j];
           if(iSquare == jSquare){
               sorted[++k] = iSquare;
               sorted[++k] = jSquare;
               j++;
               i--;
           }
           else if(iSquare < jSquare){
               sorted[++k] = iSquare;
               i--;
           }
           else {
               sorted[++k] = jSquare;
               j++;
           }
       }
       while(i >= 0){
           long iSquare = (long)arr[i] * (long)arr[i];
           sorted[++k] = iSquare;
           i--;
       }
        while(j < arr.length){
            long jSquare = (long)arr[j] * (long)arr[j];
            sorted[++k] = jSquare;
           j++;
        }
        return sorted;

    }


}
