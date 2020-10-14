package arrays;

import java.util.Arrays;
import java.util.Collections;

public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = dutchFlagPivot(new int[]{2,2,2,2,2,2,2});
        for(int i : arr){
            System.out.println(i);
        }
       // Collections.singletonList(dutchFlag(new int[]{0, 0, 0, 1, 0, 0, 0})).forEach(System.out::println);
       // Arrays.asList(dutchFlag(new int[]{2,0,2,1,0,1,2})).forEach(System.out::println);
       // Arrays.asList(dutchFlag(new int[]{0,0,0,0,0,0,0})).forEach(System.out::println);
       // Arrays.asList(dutchFlag(new int[]{2,2,2,2,2,2,2})).forEach(System.out::println);
    }
    public static int[] dutchFlag(int[] input){
        if(input == null || input.length < 1){
            return input;
        }
        // 2,1,0
       // int pivot = 1;
        int s = 0;
        int l =input.length - 1;
        int mid = 0;
        // invariance : array before mid is sorted accordingly
        while(mid <= l){
            if(input[mid] == 0){
                //swap lo and mid and increase value
                int temp = input[mid];
                input[mid] = input[s];
                input[s] = temp;
                s++;
                mid++;// as before mid array is already sorted.
            }
            else if(input[mid] == 1){
                mid++;
            }
            else {
                int temp =input[mid];
                input[mid] = input[l];
                input[l] = temp;
                l--;
            }
        }
        return input;
    }
    public static int[] dutchFlagPivot(int[] input){
        if(input == null || input.length < 1){
            return input;
        }
        // 2,1,0
        int pivot = 1;
        int s = 0;
        int l =input.length - 1;
        //int mid = 0;
        // invariance : array before s is 0 and after s 1 and 2
        while(s <= l){
            if(input[s] < pivot){
                //swap lo and mid and increase value
                s++;
            }
            else {
                int temp =input[s];
                input[s] = input[l];
                input[l] = temp;
                l--;
            }
        }
        l = input.length - 1;
        //invariance : array before s is 0 or 1 in order and after s  2
        while(s <= l){
            if(input[s] == pivot){
                s++;
            }
            else {
                int temp =input[s];
                input[s] = input[l];
                input[l] = temp;
                l--;
            }
        }

        return input;
    }
}
