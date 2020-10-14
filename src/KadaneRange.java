import java.util.Arrays;

public class KadaneRange {
    public static void main(String[] args) {
        System.out.println(maxArraySum(new int[]{2,-1,4}));
        System.out.println(maxArraySum(new int[]{2,-3,4}));
        System.out.println(maxArraySum(new int[]{-1,7,9,-13,2,5,25,-26,7,8}));
    }
    public static Range maxArraySum(int[] arr){
        if(arr == null || arr.length < 1)
            return null;
        int runningMax = arr[0];
        int runningStart = 0;
        Range maxRange = new Range(0,0,arr[0]);

        for(int i =1 ; i < arr.length; i++){
            int currVal = arr[i];
            if(runningMax <= 0){
                runningStart = i;
            }
            runningMax = Math.max(currVal, currVal + runningMax);
            if(maxRange.sum < runningMax){
                maxRange.sum = runningMax;
                maxRange.start = runningStart;
                maxRange.end = i;
            }
        }
        return maxRange;
    }
}
class Range {
    int start;
    int end;
    int sum;

    public Range(int start, int end,int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Range{" +
                "start=" + start +
                ", end=" + end +
                ", sum=" + sum +
                '}';
    }
}